package com.rafaelmfer.nasaexperience;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityAsteroidsNearFromEarth extends AppCompatActivity {

    ImageButton ibAsteroidsBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asteroids_near_from_earth);

        ibAsteroidsBack = findViewById(R.id.ibAsteroidsBack);
        ibAsteroidsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
