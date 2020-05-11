package com.rafaelmfer.nasaexperience;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderMars extends RecyclerView.ViewHolder {

    public TextView tvSunsNumber, tvDateObservation, tvTemperature, tvWindSpeed, tvPressure;

    public ViewHolderMars(@NonNull View itemView) {
        super(itemView);
        tvSunsNumber = itemView.findViewById(R.id.tvSunsNumber);
        tvDateObservation = itemView.findViewById(R.id.tvDateObservation);
        tvTemperature = itemView.findViewById(R.id.tvTemperature);
        tvWindSpeed = itemView.findViewById(R.id.tvWindSpeed);
        tvPressure = itemView.findViewById(R.id.tvPressure);
    }
}
