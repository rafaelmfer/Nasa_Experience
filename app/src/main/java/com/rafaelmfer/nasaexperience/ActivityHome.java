package com.rafaelmfer.nasaexperience;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityHome extends AppCompatActivity {
     Button btn_MarsWeather, btn_Asteroids, btn_Astronomic;
     ImageButton imgBtn_Menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imgBtn_Menu = findViewById(R.id.imgBtn_Menu);
        btn_MarsWeather = findViewById(R.id.btn_MarsWeather);
        btn_Asteroids = findViewById(R.id.btn_Asteroids);
        btn_Astronomic = findViewById(R.id.btn_Astronomic);

        btn_MarsWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_Asteroids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_Astronomic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imgBtn_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
