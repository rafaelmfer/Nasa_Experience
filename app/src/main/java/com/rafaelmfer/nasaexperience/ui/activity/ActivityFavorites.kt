package com.rafaelmfer.nasaexperience.ui.activity

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.baseviews.ActBase
import com.rafaelmfer.nasaexperience.debugging.ExceptionHandler
import com.rafaelmfer.nasaexperience.extensions.setStatusBarColor
import com.rafaelmfer.nasaexperience.extensions.viewpager.setupPagerAdapter
import com.rafaelmfer.nasaexperience.ui.fragments.FragFavoritesAstronomicImage
import com.rafaelmfer.nasaexperience.ui.fragments.FragFavoritesCelestialObjects
import com.rafaelmfer.nasaexperience.ui.fragments.FragFavoritesMars
import kotlinx.android.synthetic.main.bottom_sheet_favorites.*

class ActivityFavorites : ActBase(R.layout.bottom_sheet_favorites) {

    private val fragmentList: MutableList<Fragment> =
        mutableListOf(FragFavoritesMars(), FragFavoritesCelestialObjects(), FragFavoritesAstronomicImage())

    @SuppressLint("ClickableViewAccessibility")
    override fun ViewGroup.onView() {
        setStatusBarColor(R.color.transparent, hasLightTextColor = false)
        exceptionHandler = ExceptionHandler::class.java
        viewpager_favorites.apply {
            //Usado para não destruir o fragment, e evitar o erro de adicionar itens novamente no adapter da recycler no primeiro fragment
            offscreenPageLimit = fragmentList.size
            //SetAdapter e configure TabLayout usando uma Extension Function
            setupPagerAdapter(
                fragmentList,
                listOf("Clima de Marte", "Objetos Celestiais", "Imagens"),
                tab_favorites,
                this@ActivityFavorites.supportFragmentManager
            )
        }

        drag_view.setOnTouchListener { _, _ ->
            onBackPressed()
            true
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_out_top)
    }
}