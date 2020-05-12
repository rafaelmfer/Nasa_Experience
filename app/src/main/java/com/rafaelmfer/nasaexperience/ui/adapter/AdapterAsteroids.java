package com.rafaelmfer.nasaexperience.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.model.AsteroidModel;
import com.rafaelmfer.nasaexperience.R;
import com.rafaelmfer.nasaexperience.ui.viewholder.ViewHolderAsteroids;

import java.util.List;

public class AdapterAsteroids extends RecyclerView.Adapter<ViewHolderAsteroids> {

    private List<AsteroidModel> asteroids;

    public AdapterAsteroids(List<AsteroidModel> listAsteroids) {
        this.asteroids = listAsteroids;
    }

    @NonNull
    @Override
    public ViewHolderAsteroids onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemListAst = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_asteroids, parent, false);

        return new ViewHolderAsteroids(itemListAst);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAsteroids holder, int position) {

        AsteroidModel asteroid = asteroids.get(position);

        holder.tvDateObservationAsteroids.setText(asteroid.getAsteroidNumber());
        holder.tvAsteroidDescription.setText(asteroid.getAsteroidDescription());
    }

    @Override
    public int getItemCount() {
        return asteroids.size();
    }
}
