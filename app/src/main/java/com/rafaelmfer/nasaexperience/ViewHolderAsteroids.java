package com.rafaelmfer.nasaexperience;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderAsteroids extends RecyclerView.ViewHolder {

    public TextView tvAsteroidNumber, tvAsteroidDescription;

    public ViewHolderAsteroids(@NonNull View itemView) {
        super(itemView);

        tvAsteroidNumber = itemView.findViewById(R.id.tvAsteroidNumber);
        tvAsteroidDescription = itemView.findViewById(R.id.tvAsteroidDescription);
    }
}
