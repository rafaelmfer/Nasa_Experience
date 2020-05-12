package com.rafaelmfer.nasaexperience.ui.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.R;

public class ViewHolderAsteroids extends RecyclerView.ViewHolder {

        public TextView tvDateObservationAsteroids, tvAsteroidDescription;

        public ViewHolderAsteroids(@NonNull View itemView) {
            super(itemView);

            tvDateObservationAsteroids = itemView.findViewById(R.id.date_observation_asteroids);
            tvAsteroidDescription = itemView.findViewById(R.id.asteroid_description);
        }
}
