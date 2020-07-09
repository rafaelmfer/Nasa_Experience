package com.rafaelmfer.nasaexperience.ui.adapter

import android.view.View
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.get
import com.rafaelmfer.nasaexperience.extensions.recyclerview.ItemViewBuilder
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem
import com.rafaelmfer.nasaexperience.ui.fragments.OnItemClickRemoveImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image_of_the_day.view.*

class ItemViewBuilderAstronomicImage : ItemViewBuilder<ImageResponseItem>() {

    override val layout: Int = R.layout.item_image_of_the_day

    private val listener by lazy { context as OnItemClickRemoveImage }

    override fun View.onBind(position: Int) {
        collection[position].run {
            Picasso.get().load(url).into(image_day)
            image_title.text = title
            image_description.text = explanation
            image_date.text = date

            remove_favorite_image.setOnClickListener {
//                listener.onItemClickRemoveImage(this)
            }
        }
    }
}