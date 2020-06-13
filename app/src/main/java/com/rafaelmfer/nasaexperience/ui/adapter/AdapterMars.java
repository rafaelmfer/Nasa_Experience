package com.rafaelmfer.nasaexperience.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.R;
import com.rafaelmfer.nasaexperience.extensions.ExtDateTimeStampsKt;
import com.rafaelmfer.nasaexperience.model.marsweatherservice.InfoWeather;
import com.rafaelmfer.nasaexperience.model.marsweatherservice.MarsWeatherResponse;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class AdapterMars extends RecyclerView.Adapter<AdapterMars.MyViewHolderMars> {

    private static final String SERVER_NASA_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String DATE_TIME_PATTERN_DESIRED = "dd/MMM/yyyy' às 'HH'h'mm";
    private static final String TWO_DECIMALS = "%.2f";

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
        holder.tvSunsNumberMars.setText(holder.context.getString(R.string.sun_number, suns));
        holder.favoriteSun.setOnClickListener(view -> {
            if (((CheckBox) view).isChecked()) {
                Toast.makeText(holder.context, "selecionado", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(holder.context, "nao selecionado", Toast.LENGTH_SHORT).show();
            }
        });

        switch (position) {
            case 0:
                setDateTemperatureWindPressure(holder, marsWeather.getSunNumber1());
                break;
            case 1:
                setDateTemperatureWindPressure(holder, marsWeather.getSunNumber2());
                break;
            case 2:
                setDateTemperatureWindPressure(holder, marsWeather.getSunNumber3());
                break;
            case 3:
                setDateTemperatureWindPressure(holder, marsWeather.getSunNumber4());
                break;
            case 4:
                setDateTemperatureWindPressure(holder, marsWeather.getSunNumber5());
                break;
            case 5:
                setDateTemperatureWindPressure(holder, marsWeather.getSunNumber6());
                break;
            case 6:
                setDateTemperatureWindPressure(holder, marsWeather.getSunNumber7());
                break;
        }
    }

    private void setDateTemperatureWindPressure(@NonNull MyViewHolderMars holder, @NonNull InfoWeather sunNumber) {
        holder.tvDateObservationMars.setText(getDateObservation(holder, sunNumber));
        holder.tvTemperature.setText(getTemperature(holder, sunNumber));
        holder.tvWindSpeed.setText(getWindSpeed(holder, sunNumber));
        holder.tvPressure.setText(getPressure(holder, sunNumber));
    }

    @NotNull
    private String getDateObservation(@NonNull MyViewHolderMars holder, @NonNull InfoWeather sunNumber) {
        return holder.context.getString(
                R.string.date_of_observation,
                ExtDateTimeStampsKt.formatFromServer(
                        sunNumber.getFirstUTC(),
                        SERVER_NASA_DATE_TIME_PATTERN,
                        DATE_TIME_PATTERN_DESIRED));
    }

    @NotNull
    private String getTemperature(@NonNull MyViewHolderMars holder, @NonNull InfoWeather sunNumber) {
        return holder.context.getString(R.string.temperature_min_max,
                String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.getAtmosphericTemperature().getMn()),
                String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.getAtmosphericTemperature().getMx())
        );
    }

    @NotNull
    private String getWindSpeed(@NonNull MyViewHolderMars holder, @NonNull InfoWeather sunNumber) {
        return holder.context.getString(R.string.wind_speed_min_max,
                String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.getHorizontalWindSpeed().getMn()),
                String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.getHorizontalWindSpeed().getMx())
        );
    }

    @NotNull
    private String getPressure(@NonNull MyViewHolderMars holder, @NonNull InfoWeather sunNumber) {
        return holder.context.getString(R.string.pressure_min_max,
                String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.getAtmosphericPressure().getMn()),
                String.format(Locale.ROOT, TWO_DECIMALS, sunNumber.getAtmosphericPressure().getMx())
        );
    }

    public static class MyViewHolderMars extends RecyclerView.ViewHolder {

        Context context;
        TextView tvSunsNumberMars, tvDateObservationMars, tvWindSpeed, tvTemperature, tvPressure;
        CheckBox favoriteSun;

        public MyViewHolderMars(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvTemperature = itemView.findViewById(R.id.temperature_mars);
            tvDateObservationMars = itemView.findViewById(R.id.date_observation_mars);
            tvPressure = itemView.findViewById(R.id.pressure_mars);
            tvSunsNumberMars = itemView.findViewById(R.id.suns_number_mars);
            tvWindSpeed = itemView.findViewById(R.id.wind_speed_mars);
            favoriteSun = itemView.findViewById(R.id.favorite_sun_button);
        }
    }
}
