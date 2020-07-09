package com.rafaelmfer.nasaexperience.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.FragBind
import com.rafaelmfer.nasaexperience.data.RepositoryDatabase
import com.rafaelmfer.nasaexperience.databinding.FragFavoritesRecyclerViewBinding
import com.rafaelmfer.nasaexperience.extensions.toObjekt
import com.rafaelmfer.nasaexperience.model.marsweatherservice.InfoWeather
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars

class FragFavoritesMars : FragBind<FragFavoritesRecyclerViewBinding>(),
    OnItemClickRemoveSun {

    override val bindClass: Class<FragFavoritesRecyclerViewBinding> by lazy { FragFavoritesRecyclerViewBinding::class.java }
    private val accessMars by lazy { RepositoryDatabase(requireContext()).accessMars }
    private val adapterSunMars by lazy { AdapterMars(mutableSetOf()) }
    private val listRoom by lazy { accessMars.getMarsList() }
    private val listParcel = mutableSetOf<InfoWeather>()

    override fun FragFavoritesRecyclerViewBinding.onBoundView() {
        listRoom.forEach {
            val parcelInfoWeather = InfoWeather(
                it.atmosphericTemperature.toObjekt(),
                it.firstUTC,
                it.horizontalWindSpeed.toObjekt(),
                "",
                it.atmosphericPressure.toObjekt(),
                "",
                it.windDirection.toObjekt(),
                it.sunName,
                it.isSelected,
                it.id
            )
            listParcel.add(parcelInfoWeather)
        }


        adapterSunMars.addItems(listParcel)
        adapterSunMars.addListener(this@FragFavoritesMars)

        recyclerFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterSunMars
        }
    }

    override fun onItemClickRemoveSun(infoWeather: InfoWeather) {
        accessMars.delete(accessMars.findMarsId(infoWeather.id))
        listParcel.remove(infoWeather)
        adapterSunMars.addItems(listParcel)
        adapterSunMars.notifyDataSetChanged()
    }
}