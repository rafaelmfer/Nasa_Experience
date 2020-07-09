package com.rafaelmfer.nasaexperience.ui.adapter

import android.graphics.Typeface.BOLD
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.CheckBox
import android.widget.Toast
import com.rafaelmfer.nasaexperience.DATE_TIME_PATTERN_DESIRED
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.SERVER_NEAR_OBJECTS_DATE_PATTERN
import com.rafaelmfer.nasaexperience.SERVER_NEAR_OBJECTS_DATE_TIME_PATTERN
import com.rafaelmfer.nasaexperience.TIME_PATTERN_DESIRED
import com.rafaelmfer.nasaexperience.TWO_DECIMALS
import com.rafaelmfer.nasaexperience.customview.dialog.newPanel
import com.rafaelmfer.nasaexperience.databinding.ItemAsteroidsBinding
import com.rafaelmfer.nasaexperience.extensions.formatFromServer
import com.rafaelmfer.nasaexperience.extensions.get
import com.rafaelmfer.nasaexperience.extensions.recyclerview.ItemViewBuilderViewBinding
import com.rafaelmfer.nasaexperience.model.asteroids.Celestial
import kotlinx.android.synthetic.main.web_view.*

class ItemViewNearEarthObjects : ItemViewBuilderViewBinding<Celestial, ItemAsteroidsBinding>() {

    override val bindClass by lazy { ItemAsteroidsBinding::class.java }

    override fun ItemAsteroidsBinding.onBind(position: Int) {
        collection[position].run {

            nameObject.text = context.getString(R.string.object_name, name).setStringBoldRange(0, 5)

            dateSeenObject.text = context.getString(
                R.string.seen_in,
                if (closeApproachData[0].closeApproachDateFull != null) {
                    closeApproachData[0].closeApproachDateFull?.formatFromServer(
                        SERVER_NEAR_OBJECTS_DATE_TIME_PATTERN, DATE_TIME_PATTERN_DESIRED
                    )
                } else {
                    closeApproachData[0].closeApproachDate.formatFromServer(
                        SERVER_NEAR_OBJECTS_DATE_PATTERN, TIME_PATTERN_DESIRED
                    )
                }
            )

            potentiallyHazardousAsteroid.text = context.getString(
                R.string.potentially_hazardous_asteroid,
                if (isPotentiallyHazardousAsteroid) context.getString(R.string.yes) else context.getString(R.string.no)
            ).setStringBoldRange(0, 26)

            sentryObject.text = context.getString(
                R.string.sentry_object,
                if (isSentryObject) context.getString(R.string.yes) else context.getString(R.string.no)
            ).setStringBoldRange(0, 27)

            absoluteMagnitude.text =
                context.getString(R.string.absolute_magnitude, String.format(TWO_DECIMALS, absoluteMagnitudeH)).setStringBoldRange(0, 23)
            relativeVelocity.text = context.getString(
                R.string.relative_velocity,
                closeApproachData[0].relativeVelocity.kilometersPerHour.substring(
                    0,
                    closeApproachData[0].relativeVelocity.kilometersPerHour.indexOf(".") + 3
                ),
                closeApproachData[0].relativeVelocity.kilometersPerSecond.substring(
                    0,
                    closeApproachData[0].relativeVelocity.kilometersPerSecond.indexOf(".") + 3
                )
            )

            estimatedDiameterMin.text = context.getString(
                R.string.estimated_diameter_min,
                String.format(TWO_DECIMALS, estimatedDiameter.kilometers.estimatedDiameterMin),
                String.format(TWO_DECIMALS, estimatedDiameter.meters.estimatedDiameterMin)
            )
                .setStringBoldRange(0, 5).apply { setSpan(StyleSpan(BOLD), 14, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) }

            estimatedDiameterMax.text = context.getString(
                R.string.estimated_diameter_max,
                String.format(TWO_DECIMALS, estimatedDiameter.kilometers.estimatedDiameterMax),
                String.format(TWO_DECIMALS, estimatedDiameter.meters.estimatedDiameterMax)
            )
                .setStringBoldRange(0, 5).apply { setSpan(StyleSpan(BOLD), 14, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) }

            missDistance.text = context.getString(
                R.string.miss_distance,
                closeApproachData[0].missDistance.kilometers.substring(0, closeApproachData[0].missDistance.kilometers.indexOf(".") + 3),
                closeApproachData[0].missDistance.lunar.substring(0, closeApproachData[0].missDistance.lunar.indexOf(".") + 3)
            )
                .setStringBoldRange(0, 11).apply { setSpan(StyleSpan(BOLD), 23, 32, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) }

            favoriteNearObjectsButton.setOnClickListener { view ->
                if ((view as CheckBox).isChecked) {
                    Toast.makeText(view.context, "selecionado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(view.context, "nao selecionado", Toast.LENGTH_SHORT).show()
                }
            }
            moreInfo.setOnClickListener {
                it.newPanel(layout = R.layout.web_view) {
                    web_toolbar.titleToolbar = name
                    web_toolbar.updateTitleToolbar()
                    web_toolbar.setButtonLeftAction { dismiss() }
                    webView.loadUrl(nasaJplUrl.replace("http:", "https:"))
                }
            }
        }
    }

    private fun String.setStringBoldRange(start: Int, end: Int) = SpannableString(this).apply {
        setSpan(StyleSpan(BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}