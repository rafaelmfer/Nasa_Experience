package com.rafaelmfer.nasaexperience.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rafaelmfer.nasaexperience.R;

import org.jetbrains.annotations.NotNull;

public class ActivityHome extends AppCompatActivity {

    ImageButton ibMenu;
    Button btMarsWeather, btAsteroids, btAstronomicImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindViews();

        ibMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO esperar Yuri ou João ensinar sobre Navigation Drawer
            }
        });

        btMarsWeather.setOnClickListener(clickToStartNewActivity(ActivityMarsWeather.class));
        btAsteroids.setOnClickListener(clickToStartNewActivity(ActivityAsteroidsNearFromEarth.class));
        btAstronomicImage.setOnClickListener(clickToStartNewActivity(ActivityAstronomicImageOfTheDay.class));
    }

    private void bindViews() {
        ibMenu = findViewById(R.id.ibMenu);
        btMarsWeather = findViewById(R.id.btMarsWeather);
        btAsteroids = findViewById(R.id.btAsteroids);
        btAstronomicImage = findViewById(R.id.btAstronomicImage);
    }

    @NotNull
    private View.OnClickListener clickToStartNewActivity(Class<?> activity) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), activity));
            }
        };
    }
}
