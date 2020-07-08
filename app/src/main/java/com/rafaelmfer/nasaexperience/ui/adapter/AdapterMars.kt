package com.rafaelmfer.nasaexperience.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rafaelmfer.nasaexperience.DATE_TIME_PATTERN_DESIRED
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.SERVER_MARS_WEATHER_DATE_TIME_PATTERN
import com.rafaelmfer.nasaexperience.TWO_DECIMALS
import com.rafaelmfer.nasaexperience.extensions.formatFromServer
import com.rafaelmfer.nasaexperience.extensions.get
import com.rafaelmfer.nasaexperience.model.marsweatherservice.InfoWeather
import com.rafaelmfer.nasaexperience.ui.activity.OnItemClickSunMars
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars.MyViewHolderMars
import java.util.Locale

class AdapterMars(private val sunSet: MutableSet<InfoWeather>, private val sunNameSet: MutableSet<String>) :
    RecyclerView.Adapter<MyViewHolderMars>() {

    private lateinit var listenerOnSunClick: OnItemClickSunMars

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolderMars(
        LayoutInflater.from(parent.context).inflate(R.layout.item_suns_mars_card, parent, false)
    )

    override fun getItemCount(): Int {
        return sunSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolderMars, position: Int) {
        sunSet.get(position).run {
            holder.apply {
                tvSunsNumberMars.text = holder.context.getString(R.string.sun_number, sunNameSet.get(position))
                favoriteSun.setOnClickListener { view: View ->
                    if ((view as CheckBox).isChecked) {
                        listenerOnSunClick.getPositionSunMar(this@run);
                        Toast.makeText(holder.context, "selecionado", Toast.LENGTH_SHORT).show()
                    } else {
                        listenerOnSunClick.getPositionSunMar(this@run);
                        Toast.makeText(holder.context, "nao selecionado", Toast.LENGTH_SHORT).show()
                    }
                }
                setDateTemperatureWindPressure(this@run)
            }
        }
    }

    private fun MyViewHolderMars.setDateTemperatureWindPressure(sunNumber: InfoWeather) {
        tvDateObservationMars.text = getDateObservation(sunNumber)
        tvTemperature.text = getTemperature(sunNumber)
        tvWindSpeed.text = getWindSpeed(sunNumber)
        tvPressure.text = getPressure(sunNumber)
    }

    private fun MyViewHolderMars.getDateObservation(sunNumber: InfoWeather) = context.getString(
        R.string.date_of_observation,
        sunNumber.firstUTC.formatFromServer(SERVER_MARS_WEATHER_DATE_TIME_PATTERN, DATE_TIME_PATTERN_DESIRED)
    )

    private fun MyViewHolderMars.getTemperature(sunNumber: InfoWeather) = context.getString(
        R.string.temperature_min_max,
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.atmosphericTemperature.mn),
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.atmosphericTemperature.mx)
    )

    private fun MyViewHolderMars.getWindSpeed(sunNumber: InfoWeather) = context.getString(
        R.string.wind_speed_min_max,
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.horizontalWindSpeed.mn),
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.horizontalWindSpeed.mx)
    )

    private fun MyViewHolderMars.getPressure(sunNumber: InfoWeather) = context.getString(
        R.string.pressure_min_max,
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.atmosphericPressure.mn),
        String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.atmosphericPressure.mx)
    )

    class MyViewHolderMars(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var context: Context
        var tvSunsNumberMars: TextView
        var tvDateObservationMars: TextView
        var tvWindSpeed: TextView
        var tvTemperature: TextView
        var tvPressure: TextView
        var favoriteSun: CheckBox

        init {
            context = itemView.context
            tvTemperature = itemView.findViewById(R.id.temperature_mars)
            tvDateObservationMars = itemView.findViewById(R.id.date_observation_mars)
            tvPressure = itemView.findViewById(R.id.pressure_mars)
            tvSunsNumberMars = itemView.findViewById(R.id.suns_number_mars)
            tvWindSpeed = itemView.findViewById(R.id.wind_speed_mars)
            favoriteSun = itemView.findViewById(R.id.favorite_sun_button)
        }
    }
}