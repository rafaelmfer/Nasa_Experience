package com.rafaelmfer.nasaexperience.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.R;
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars;
import com.rafaelmfer.nasaexperience.model.PostsMars;

import java.util.ArrayList;
import java.util.List;

public class ActivityMarsWeatherSuns extends AppCompatActivity {
     RecyclerView recyclerView_mars;
     ImageButton ibMarsWeatherBack;
      List<PostsMars> posts = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars_weather_suns);

        recyclerView_mars = findViewById(R.id.recycler_mars);
        //Define Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView_mars.setLayoutManager( layoutManager );
        //Define Adapter
        newPosts();

        AdapterMars adapterMars = new AdapterMars(posts);
        recyclerView_mars.setAdapter(adapterMars);

        ibMarsWeatherBack = findViewById(R.id.mars_weather_back);
        ibMarsWeatherBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void newPosts(){
        posts.add(new PostsMars("ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
        posts.add(new PostsMars("ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
        posts.add(new PostsMars("ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
        posts.add(new PostsMars("ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));
        posts.add(new PostsMars("ObservationsMars", "Pressure",
                "Mars Numbers", "Temperature",
                "Presure"));

    }
}
