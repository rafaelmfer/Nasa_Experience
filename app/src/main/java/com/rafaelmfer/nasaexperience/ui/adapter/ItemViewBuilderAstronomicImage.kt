package com.rafaelmfer.nasaexperience.ui.adapter

import android.view.View
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.get
import com.rafaelmfer.nasaexperience.extensions.recyclerview.ItemViewBuilder
import com.rafaelmfer.nasaexperience.model.imageoftheday.EntityImageList
import kotlinx.android.synthetic.main.item_image_of_the_day.view.*

class ItemViewBuilderAstronomicImage : ItemViewBuilder<EntityImageList>() {

    override val layout: Int = R.layout.item_image_of_the_day

    override fun View.onBind(position: Int) {
        val item = collection.get(position)
        image_day.setImageDrawable(context.getDrawable(R.drawable.wallpaper_favorites))
    }
}