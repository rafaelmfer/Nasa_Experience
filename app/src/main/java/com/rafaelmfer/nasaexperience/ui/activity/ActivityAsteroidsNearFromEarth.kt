package com.rafaelmfer.nasaexperience.ui.activity

import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.baseviews.ActBase
import com.rafaelmfer.nasaexperience.extensions.recyclerview.setupViewBinding
import com.rafaelmfer.nasaexperience.model.asteroids.CelestialObjects
import com.rafaelmfer.nasaexperience.ui.adapter.ItemViewNearEarthObjects
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelNearEarthObjects
import kotlinx.android.synthetic.main.activity_asteroids_near_from_earth.*

class ActivityAsteroidsNearFromEarth : ActBase(R.layout.activity_asteroids_near_from_earth) {

    var setNearObjects = mutableSetOf<MutableSet<CelestialObjects>>()
    private val viewModel: ViewModelNearEarthObjects by viewModels()
    private var celestialObject = CelestialObjects()

    override fun onView() {
        super.onView()
        asteroids_back.setOnClickListener { onBackPressed() }
        setupRecycler()

        viewModel.nearEarthObjects.observe(this@ActivityAsteroidsNearFromEarth, Observer { asteroidsResponse ->
            val mutableSetCelestial = mutableSetOf<CelestialObjects>()
            asteroidsResponse.nearEarthObjects.run {
                x20150907.forEach {
                    it to celestialObject
                    mutableSetCelestial.add(celestialObject)
                    setNearObjects.add(mutableSetCelestial)
                }
                x20150908.forEach {
                    it to celestialObject
                    mutableSetCelestial.add(celestialObject)
                    setNearObjects.add(mutableSetCelestial)
                }
            }
        })
        search_view_objects.setOnQueryTextListener(onTextSubmit { viewModel.getNearEarthObjects(it) })
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