package com.rafaelmfer.nasaexperience;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MarsWeatherSunsActivity extends AppCompatActivity {

    ImageButton ibMarsWeatherBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars_weather_suns);

        ibMarsWeatherBack = findViewById(R.id.ibMarsWeatherBack);
        ibMarsWeatherBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
