package com.rafaelmfer.nasaexperience.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.R;
import com.rafaelmfer.nasaexperience.model.marsweatherservice.MarsWeatherResponse;

public class AdapterMars extends RecyclerView.Adapter<AdapterMars.MyViewHolderMars> {

    public MarsWeatherResponse marsWeather = new MarsWeatherResponse();

    public AdapterMars() {
    }

    public void setMarsWeather(MarsWeatherResponse marsWeather) {
        this.marsWeather = marsWeather;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolderMars onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemListMars = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_suns_mars_card, parent, false);
        return new MyViewHolderMars(itemListMars);
    }

    @Override
    public int getItemCount() {
        return marsWeather.getSolKeys().size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderMars holder, int position) {
        String suns = marsWeather.getSolKeys().get(position);
        holder.tvSunsNumberMars.setText(suns);

        switch (position) {
            case 0:
                holder.tvDateObservationMars.setText(marsWeather.getSunNumber1().getFirstUTC());
                holder.tvPressure.setText(String.valueOf(marsWeather.getSunNumber1().getAtmosphericPressure().getAv()));
                holder.tvWindSpeed.setText(String.valueOf(marsWeather.getSunNumber1().getHorizontalWindSpeed().getAv()));
                holder.tvTemperature.setText(String.valueOf(marsWeather.getSunNumber1().getAtmosphericTemperature().getAv()));
                break;
            case 1:
                holder.tvDateObservationMars.setText(marsWeather.getSunNumber2().getFirstUTC());
                holder.tvPressure.setText(String.valueOf(marsWeather.getSunNumber2().getAtmosphericPressure().getAv()));
                holder.tvWindSpeed.setText(String.valueOf(marsWeather.getSunNumber2().getHorizontalWindSpeed().getAv()));
                holder.tvTemperature.setText(String.valueOf(marsWeather.getSunNumber2().getAtmosphericTemperature().getAv()));
                break;
            case 2:
                holder.tvDateObservationMars.setText(marsWeather.getSunNumber3().getFirstUTC());
                holder.tvPressure.setText(String.valueOf(marsWeather.getSunNumber3().getAtmosphericPressure().getAv()));
                holder.tvWindSpeed.setText(String.valueOf(marsWeather.getSunNumber3().getHorizontalWindSpeed().getAv()));
                holder.tvTemperature.setText(String.valueOf(marsWeather.getSunNumber3().getAtmosphericTemperature().getAv()));
                break;
            case 3:
                holder.tvDateObservationMars.setText(marsWeather.getSunNumber4().getFirstUTC());
                holder.tvPressure.setText(String.valueOf(marsWeather.getSunNumber4().getAtmosphericPressure().getAv()));
                holder.tvWindSpeed.setText(String.valueOf(marsWeather.getSunNumber4().getHorizontalWindSpeed().getAv()));
                holder.tvTemperature.setText(String.valueOf(marsWeather.getSunNumber4().getAtmosphericTemperature().getAv()));
                break;
            case 4:
                holder.tvDateObservationMars.setText(marsWeather.getSunNumber5().getFirstUTC());
                holder.tvPressure.setText(String.valueOf(marsWeather.getSunNumber5().getAtmosphericPressure().getAv()));
                holder.tvWindSpeed.setText(String.valueOf(marsWeather.getSunNumber5().getHorizontalWindSpeed().getAv()));
                holder.tvTemperature.setText(String.valueOf(marsWeather.getSunNumber5().getAtmosphericTemperature().getAv()));
                break;
            case 5:
                holder.tvDateObservationMars.setText(marsWeather.getSunNumber6().getFirstUTC());
                holder.tvPressure.setText(String.valueOf(marsWeather.getSunNumber6().getAtmosphericPressure().getAv()));
                holder.tvWindSpeed.setText(String.valueOf(marsWeather.getSunNumber6().getHorizontalWindSpeed().getAv()));
                holder.tvTemperature.setText(String.valueOf(marsWeather.getSunNumber6().getAtmosphericTemperature().getAv()));
                break;
            case 6:
                holder.tvDateObservationMars.setText(marsWeather.getSunNumber7().getFirstUTC());
                holder.tvPressure.setText(String.valueOf(marsWeather.getSunNumber7().getAtmosphericPressure().getAv()));
                holder.tvWindSpeed.setText(String.valueOf(marsWeather.getSunNumber7().getHorizontalWindSpeed().getAv()));
                holder.tvTemperature.setText(String.valueOf(marsWeather.getSunNumber7().getAtmosphericTemperature().getAv()));
                break;
        }
    }

    public static class MyViewHolderMars extends RecyclerView.ViewHolder {

        TextView tvSunsNumberMars, tvDateObservationMars, tvWindSpeed, tvTemperature, tvPressure;

        public MyViewHolderMars(@NonNull View itemView) {
            super(itemView);
            tvTemperature = itemView.findViewById(R.id.temperature_mars);
            tvDateObservationMars = itemView.findViewById(R.id.date_observation_mars);
            tvPressure = itemView.findViewById(R.id.pressure_mars);
            tvSunsNumberMars = itemView.findViewById(R.id.suns_number_mars);
            tvWindSpeed = itemView.findViewById(R.id.wind_speed_mars);
        }
    }
}
