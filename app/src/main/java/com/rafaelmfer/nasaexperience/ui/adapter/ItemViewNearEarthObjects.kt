package com.rafaelmfer.nasaexperience.ui.adapter

import android.widget.CheckBox
import android.widget.Toast
import com.rafaelmfer.nasaexperience.databinding.ItemAsteroidsBinding
import com.rafaelmfer.nasaexperience.extensions.formatFromServer
import com.rafaelmfer.nasaexperience.extensions.get
import com.rafaelmfer.nasaexperience.extensions.recyclerview.ItemViewBuilderViewBinding
import com.rafaelmfer.nasaexperience.model.asteroids.Celestial

class ItemViewNearEarthObjects : ItemViewBuilderViewBinding<Celestial, ItemAsteroidsBinding>() {

    override val bindClass by lazy { ItemAsteroidsBinding::class.java }

    override fun ItemAsteroidsBinding.onBind(position: Int) {
        collection.get(position).run {
            nameObject.text = name
            dateSeenObject.text = if (closeApproachData[0].closeApproachDateFull != null) {
                closeApproachData[0].closeApproachDateFull?.formatFromServer(
                "yyyy-MMM-dd HH:mm", "dd/MMM/yyyy' as 'HH'h'mm"
            )} else {
                closeApproachData[0].closeApproachDate.formatFromServer(
                    "yyyy-MM-dd", "dd/MMM/yyyy"
                )
            }

            potentiallyHazardousAsteroid.text = if (isPotentiallyHazardousAsteroid) "Sim" else "Não"
            sentryObject.text = if (isSentryObject) "Sim" else "Não"

            absoluteMagnitude.text = absoluteMagnitudeH.toString()
            relativeVelocityKmh.text = closeApproachData[0].relativeVelocity.kilometersPerHour
            relativeVelocityKms.text = closeApproachData[0].relativeVelocity.kilometersPerSecond
            estimatedDiameterMin.text = estimatedDiameter.kilometers.estimatedDiameterMin.toString()
            estimatedDiameterMax.text = estimatedDiameter.kilometers.estimatedDiameterMax.toString()
            missDistanceKm.text = closeApproachData[0].missDistance.kilometers

            favoriteSunButton.setOnClickListener { view ->
                if ((view as CheckBox).isChecked) {
                    Toast.makeText(view.context, "selecionado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(view.context, "nao selecionado", Toast.LENGTH_SHORT).show()
                }
            }
//            moreInfo
        }
    }

}