package com.rafaelmfer.nasaexperience.activityMars;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.R;
import com.rafaelmfer.nasaexperience.adapter.AdapterMars;
import com.rafaelmfer.nasaexperience.modelMars.Posts;

import java.util.ArrayList;
import java.util.List;

public class ActivityMarsWeatherSuns extends AppCompatActivity {
     RecyclerView recyclerView_mars;
     ImageButton ibMarsWeatherBack;
      List<Posts> posts = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars_weather_suns);

        recyclerView_mars = findViewById(R.id.recyclerView_mars);
        //Define Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView_mars.setLayoutManager( layoutManager );
        //Define Adapter
        this.newPosts();

        AdapterMars adapterMars = new AdapterMars(posts);
        recyclerView_mars.setAdapter(adapterMars);

        ibMarsWeatherBack = findViewById(R.id.ibMarsWeatherBack);
        ibMarsWeatherBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void newPosts(){
        Posts posts = new Posts();
        posts.setTvDateObservationMars("ObservationMars");
        this.posts.add(posts);
        posts.setTvPressure("Pressure");
        this.posts.add(posts);
        posts.setTvSunsNumberMars("Mars Number");
        this.posts.add(posts);
        posts.setTvTemperature("Temperature");
        this.posts.add(posts);
        posts.setTvWindSpeed("WindSpeed");
        this.posts.add(posts);
        posts.setvDecoratorSuns(R.color.blue_50);
        this.posts.add(posts);
    }
}
