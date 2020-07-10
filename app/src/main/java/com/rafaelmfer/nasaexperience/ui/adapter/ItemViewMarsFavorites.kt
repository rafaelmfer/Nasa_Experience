package com.rafaelmfer.nasaexperience.ui.adapter

import android.view.View
import com.rafaelmfer.nasaexperience.DATE_TIME_PATTERN_DESIRED
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.SERVER_MARS_WEATHER_DATE_TIME_PATTERN
import com.rafaelmfer.nasaexperience.TWO_DECIMALS
import com.rafaelmfer.nasaexperience.databinding.ItemSunsMarsCardBinding
import com.rafaelmfer.nasaexperience.extensions.formatFromServer
import com.rafaelmfer.nasaexperience.extensions.get
import com.rafaelmfer.nasaexperience.extensions.recyclerview.ItemViewBuilderViewBinding
import com.rafaelmfer.nasaexperience.model.marsweatherservice.InfoWeather
import java.util.Locale

class ItemViewMarsFavorites : ItemViewBuilderViewBinding<InfoWeather, ItemSunsMarsCardBinding>() {

    override val bindClass: Class<ItemSunsMarsCardBinding>
        get() = ItemSunsMarsCardBinding::class.java

    override fun ItemSunsMarsCardBinding.onBind(position: Int) {
        collection[position].run {
            sunsNumberMars.text = context.getString(R.string.sun_number, sunName)
            if (isSelected) {
                favoriteSunButton.visibility = View.GONE
                removeFavoriteSun.apply {
                    visibility = View.VISIBLE
                    setOnClickListener {

                    }
                }
            }
            setDateTemperatureWindPressure(this@run)
        }
    }

    private fun ItemSunsMarsCardBinding.setDateTemperatureWindPressure(sunNumber: InfoWeather) {
        dateObservationMars.text = getDateObservation(sunNumber)
        temperatureMars.text = getTemperature(sunNumber)
        windSpeedMars.text = getWindSpeed(sunNumber)
        pressureMars.text = getPressure(sunNumber)
    }

    private fun getDateObservation(sunNumber: InfoWeather) = context.getString(
        R.string.date_of_observation,
        sunNumber.firstUTC.formatFromServer(SERVER_MARS_WEATHER_DATE_TIME_PATTERN, DATE_TIME_PATTERN_DESIRED)
    )

    private fun getTemperature(sunNumber: InfoWeather) = context.getString(
        R.string.temperature_min_max,
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.atmosphericTemperature.mn),
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.atmosphericTemperature.mx)
    )

    private fun getWindSpeed(sunNumber: InfoWeather) = context.getString(
        R.string.wind_speed_min_max,
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.horizontalWindSpeed.mn),
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.horizontalWindSpeed.mx)
    )

    private fun getPressure(sunNumber: InfoWeather) = context.getString(
        R.string.pressure_min_max,
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.atmosphericPressure.mn),
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.atmosphericPressure.mx)
    )

}