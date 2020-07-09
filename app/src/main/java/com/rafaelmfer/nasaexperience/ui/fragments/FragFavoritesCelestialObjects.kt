package com.rafaelmfer.nasaexperience.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.FragBind
import com.rafaelmfer.nasaexperience.data.RepositoryDatabase
import com.rafaelmfer.nasaexperience.databinding.FragFavoritesRecyclerViewBinding
import com.rafaelmfer.nasaexperience.extensions.recyclerview.setupViewBinding
import com.rafaelmfer.nasaexperience.extensions.recyclerview.update
import com.rafaelmfer.nasaexperience.extensions.toObjekt
import com.rafaelmfer.nasaexperience.extensions.toObjekts
import com.rafaelmfer.nasaexperience.model.asteroids.Celestial
import com.rafaelmfer.nasaexperience.ui.adapter.ItemViewNearEarthObjects

class FragFavoritesCelestialObjects : FragBind<FragFavoritesRecyclerViewBinding>(), OnItemClickRemoveNearObjects {

    override val bindClass: Class<FragFavoritesRecyclerViewBinding> by lazy { FragFavoritesRecyclerViewBinding::class.java }
    private val accessNearObjects by lazy { RepositoryDatabase(requireContext()).accessNearObjects }
    private val listRoom by lazy { accessNearObjects.getNearObjectsList() }
    private var listParcel = mutableSetOf<Celestial>()

    override fun FragFavoritesRecyclerViewBinding.onBoundView() {
        listRoom.forEach {
            val parcelInfoWeather = Celestial(
                name = it.name,
                nasaJplUrl = it.nasaJplUrl,
                absoluteMagnitudeH = it.absoluteMagnitudeH,
                estimatedDiameter = it.estimatedDiameter.toObjekt(),
                isPotentiallyHazardousAsteroid = it.isPotentiallyHazardousAsteroid,
                closeApproachData = it.closeApproachData.toObjekts(),
                isSentryObject = it.isSentryObject,
                isSelected = true,
                id = it.id2
            )
            listParcel.add(parcelInfoWeather)
        }

        recyclerFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setupViewBinding<ItemViewNearEarthObjects>(listParcel)
        }
    }

    override fun onItemClickRemoveObjects(celestialObjects: Celestial) {
        accessNearObjects.delete(accessNearObjects.findObjectsIdString(celestialObjects.id))
        listParcel.remove(celestialObjects)
        binding.recyclerFavorites.update()
    }
}