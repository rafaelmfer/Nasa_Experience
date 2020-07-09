package com.rafaelmfer.nasaexperience.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.FragBind
import com.rafaelmfer.nasaexperience.data.RepositoryDatabase
import com.rafaelmfer.nasaexperience.databinding.FragFavoritesRecyclerViewBinding
import com.rafaelmfer.nasaexperience.extensions.recyclerview.setup
import com.rafaelmfer.nasaexperience.extensions.recyclerview.update
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem
import com.rafaelmfer.nasaexperience.ui.adapter.ItemViewBuilderAstronomicImage

class FragFavoritesAstronomicImage : FragBind<FragFavoritesRecyclerViewBinding>(),
    OnItemClickRemoveImage {

    override val bindClass: Class<FragFavoritesRecyclerViewBinding> by lazy { FragFavoritesRecyclerViewBinding::class.java }
    private val accessImage by lazy { RepositoryDatabase(requireContext()).accessImageOfDay}

    override fun FragFavoritesRecyclerViewBinding.onBoundView() {
        val listRoom = accessImage.getImageList()

        recyclerFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setup<ItemViewBuilderAstronomicImage>(listRoom)
        }
    }

    override fun onItemClickRemoveImage(imageResponseItem: ImageResponseItem) {
        accessImage.delete(imageResponseItem)
        binding.recyclerFavorites.update()
    }
}