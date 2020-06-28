package com.rafaelmfer.nasaexperience.ui.activity

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.baseviews.ActBase
import com.rafaelmfer.nasaexperience.extensions.viewpager.setupPagerAdapter
import kotlinx.android.synthetic.main.bottom_sheet_favorites.*

class ActivityFavorites : ActBase(R.layout.bottom_sheet_favorites) {

    private val fragmentList: MutableList<Fragment> =
        mutableListOf(FragFavoritesCelestialObjects(), FragFavoritesMars(), FragFavoritesAstronomicImage())

    override fun ViewGroup.onView() {
        viewpager_favorites.apply {
            //Usado para não destruir o fragment, e evitar o erro de adicionar itens novamente no adapter da recycler no primeiro fragment
            offscreenPageLimit = fragmentList.size
            //SetAdapter e configure TabLayout usando uma Extension Function
            setupPagerAdapter(
                fragmentList,
                listOf("Objetos Celestiais", "Clima de Marte", "Imagens"),
                tab_favorites,
                this@ActivityFavorites.supportFragmentManager
            )
        }
    }
}