package com.rafaelmfer.nasaexperience.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.FragBind
import com.rafaelmfer.nasaexperience.data.RepositoryDatabase
import com.rafaelmfer.nasaexperience.databinding.FragFavoritesRecyclerViewBinding
import com.rafaelmfer.nasaexperience.extensions.recyclerview.setupViewBinding
import com.rafaelmfer.nasaexperience.model.asteroids.Celestial
import com.rafaelmfer.nasaexperience.ui.adapter.ItemViewNearEarthObjects

class FragFavoritesCelestialObjects : FragBind<FragFavoritesRecyclerViewBinding>() {

    override val bindClass: Class<FragFavoritesRecyclerViewBinding> by lazy { FragFavoritesRecyclerViewBinding::class.java }

    override fun FragFavoritesRecyclerViewBinding.onBoundView() {
        val listRoom = RepositoryDatabase(requireContext()).accessNearObjects.getNearObjectsList()

        recyclerFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setupViewBinding<ItemViewNearEarthObjects>(mutableSetOf<Celestial>())
        }
    }
}