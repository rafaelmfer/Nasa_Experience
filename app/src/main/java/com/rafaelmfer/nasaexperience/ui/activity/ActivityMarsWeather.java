package com.rafaelmfer.nasaexperience.ui.activity;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.baseviews.ActBind;
import com.rafaelmfer.nasaexperience.databinding.ActivityMarsWeatherBinding;
import com.rafaelmfer.nasaexperience.model.PostsMars;
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ActivityMarsWeather extends ActBind<ActivityMarsWeatherBinding> {

    List<PostsMars> posts = new ArrayList<>();

    @NotNull
    @Override
    public Class<ActivityMarsWeatherBinding> getBindClass() {
        return ActivityMarsWeatherBinding.class;
    }

    @Override
    public void onBoundView(@NotNull ActivityMarsWeatherBinding binding) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerMars.setLayoutManager(layoutManager);
        newPosts();
        AdapterMars adapterMars = new AdapterMars(posts);
        binding.recyclerMars.setAdapter(adapterMars);

        binding.marsWeatherBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void newPosts() {
        posts.add(new PostsMars(0, "ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
        posts.add(new PostsMars(1, "ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
        posts.add(new PostsMars(2, "ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
        posts.add(new PostsMars(3, "ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
        posts.add(new PostsMars(4, "ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
    }
}
