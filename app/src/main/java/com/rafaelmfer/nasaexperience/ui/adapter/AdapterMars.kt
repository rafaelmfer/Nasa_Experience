package com.rafaelmfer.nasaexperience.ui.adapter

import android.app.AlertDialog
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
import com.rafaelmfer.nasaexperience.customview.button.ButtonMaterialIcon
import com.rafaelmfer.nasaexperience.extensions.formatFromServer
import com.rafaelmfer.nasaexperience.extensions.get
import com.rafaelmfer.nasaexperience.model.marsweatherservice.InfoWeather
import com.rafaelmfer.nasaexperience.ui.activity.OnItemClickSunMars
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars.MyViewHolderMars
import com.rafaelmfer.nasaexperience.ui.fragments.OnItemClickRemoveSun
import java.util.Locale

class AdapterMars(private var sunSet: MutableSet<InfoWeather>) : RecyclerView.Adapter<MyViewHolderMars>() {

    private var context: Context? = null
    private var listener : OnItemClickRemoveSun? = null

    fun addListener(listener: OnItemClickRemoveSun) {
        this.listener = listener
    }

    fun addItems(sunSet: MutableSet<InfoWeather>) {
        this.sunSet = sunSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMars {
        if (context == null) {
            context = parent.context
        }
        return MyViewHolderMars(LayoutInflater.from(parent.context).inflate(R.layout.item_suns_mars_card, parent, false))
    }

    override fun getItemCount(): Int = sunSet.size

    override fun onBindViewHolder(holder: MyViewHolderMars, position: Int) {
        sunSet[position].run {
            holder.apply {
                tvSunsNumberMars.text = holder.context.getString(R.string.sun_number, sunName)

                if (isSelected) {
                    favoriteSun.visibility = View.GONE
                    removeFavoriteSun.apply {
                        visibility = View.VISIBLE
                        setOnClickListener {
                            val builder = AlertDialog.Builder(context)
                            builder.setMessage("Deseja remover o item?")
                            builder.setCancelable(true)
                            builder.setNegativeButton("Cancelar") { dialogInterface, cancel ->
                                dialogInterface.cancel()
                            }
                            builder.setPositiveButton("Remover") { dialogInterface, exit ->
                                listener?.onItemClickRemoveSun(this@run)
                            }
                            val alertDialog = builder.create()
                            alertDialog.show()
                        }
                    }
                } else {
                    favoriteSun.setOnClickListener { view: View ->
                        if ((view as CheckBox).isChecked) {
                            (context as OnItemClickSunMars).addPositionSunMar(this@run)
                            Toast.makeText(holder.context, "Adicionado aos Favoritos", Toast.LENGTH_SHORT).show()
                        } else {
//                            (context as OnItemClickSunMars).addPositionSunMar(this@run);
//                            Toast.makeText(holder.context, "Removido aos Favoritos", Toast.LENGTH_SHORT).show()
                        }
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
        var context: Context = itemView.context
        var tvSunsNumberMars: TextView = itemView.findViewById(R.id.suns_number_mars)
        var tvDateObservationMars: TextView = itemView.findViewById(R.id.date_observation_mars)
        var tvWindSpeed: TextView = itemView.findViewById(R.id.wind_speed_mars)
        var tvTemperature: TextView = itemView.findViewById(R.id.temperature_mars)
        var tvPressure: TextView = itemView.findViewById(R.id.pressure_mars)
        var favoriteSun: CheckBox = itemView.findViewById(R.id.favorite_sun_button)
        var removeFavoriteSun: ButtonMaterialIcon = itemView.findViewById(R.id.remove_favorite_sun)
    }
}