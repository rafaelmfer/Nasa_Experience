package com.rafaelmfer.nasaexperience.ui.activity

import android.view.ViewGroup
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.baseviews.ActBase
import com.rafaelmfer.nasaexperience.debugging.ExceptionHandler
import com.rafaelmfer.nasaexperience.extensions.addMarginTopStatusBarHeight
import com.rafaelmfer.nasaexperience.extensions.recyclerview.setupViewBinding
import com.rafaelmfer.nasaexperience.extensions.recyclerview.update
import com.rafaelmfer.nasaexperience.extensions.setFullScreen
import com.rafaelmfer.nasaexperience.model.asteroids.Celestial
import com.rafaelmfer.nasaexperience.ui.adapter.ItemViewNearEarthObjects
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelNearEarthObjects
import kotlinx.android.synthetic.main.activity_asteroids_near_from_earth.*

class ActivityAsteroidsNearFromEarth : ActBase(R.layout.activity_asteroids_near_from_earth) {

    private var setNearObjects = mutableSetOf<Celestial>()
    private val viewModel: ViewModelNearEarthObjects by viewModels()

    override fun ViewGroup.onView() {
        exceptionHandler = ExceptionHandler::class.java
        setFullScreen()
        asteroids_back.apply {
            addMarginTopStatusBarHeight()
            setOnClickListener { onBackPressed() }
        }
        setupRecycler()

        viewModel.nearEarthObjects.observe(this@ActivityAsteroidsNearFromEarth, Observer { celestialObjectsResponse ->
            celestialObjectsResponse.nearEarthObjects.run {
                setNearObjects.addAll(x20150907)
                setNearObjects.addAll(x20150908)
                recycler_objects.update()
            }
        })
        search_view_objects.setOnQueryTextListener(onTextSubmit { viewModel.getCelestialObjects(it) })
    }

    private fun setupRecycler() {
        recycler_objects.layoutManager = LinearLayoutManager(this)
        recycler_objects.setupViewBinding<ItemViewNearEarthObjects>(setNearObjects)
    }

    private fun onTextSubmit(block: (String) -> Unit) = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(string: String): Boolean {
            block(string)
            return false
        }

        override fun onQueryTextChange(s: String): Boolean {
            return false
        }
    }
}