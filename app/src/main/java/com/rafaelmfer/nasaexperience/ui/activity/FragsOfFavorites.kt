package com.rafaelmfer.nasaexperience.ui.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.FragBind
import com.rafaelmfer.nasaexperience.databinding.FragFavoritesRecyclerViewBinding
import com.rafaelmfer.nasaexperience.extensions.recyclerview.setup
import com.rafaelmfer.nasaexperience.extensions.recyclerview.setupViewBinding
import com.rafaelmfer.nasaexperience.model.asteroids.Celestial
import com.rafaelmfer.nasaexperience.model.marsweatherservice.InfoWeather
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars
import com.rafaelmfer.nasaexperience.ui.adapter.ItemViewBuilderAstronomicImage
import com.rafaelmfer.nasaexperience.ui.adapter.ItemViewNearEarthObjects

class FragFavoritesCelestialObjects : FragBind<FragFavoritesRecyclerViewBinding>() {

    override val bindClass: Class<FragFavoritesRecyclerViewBinding> by lazy { FragFavoritesRecyclerViewBinding::class.java }

    override fun FragFavoritesRecyclerViewBinding.onBoundView() {
        recyclerFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setupViewBinding<ItemViewNearEarthObjects>(mutableSetOf<Celestial>())
        }
    }
}

class FragFavoritesMars : FragBind<FragFavoritesRecyclerViewBinding>() {

    override val bindClass: Class<FragFavoritesRecyclerViewBinding> by lazy { FragFavoritesRecyclerViewBinding::class.java }

    override fun FragFavoritesRecyclerViewBinding.onBoundView() {
        recyclerFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdapterMars(mutableSetOf<InfoWeather>(), mutableSetOf<String>())
        }
    }
}

class FragFavoritesAstronomicImage : FragBind<FragFavoritesRecyclerViewBinding>() {

    override val bindClass: Class<FragFavoritesRecyclerViewBinding> by lazy { FragFavoritesRecyclerViewBinding::class.java }

    override fun FragFavoritesRecyclerViewBinding.onBoundView() {
        recyclerFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setup<ItemViewBuilderAstronomicImage>(mutableSetOf<Celestial>())
        }
    }
}
