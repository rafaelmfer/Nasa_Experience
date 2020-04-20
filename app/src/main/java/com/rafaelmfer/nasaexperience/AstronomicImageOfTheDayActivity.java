package com.rafaelmfer.nasaexperience;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AstronomicImageOfTheDayActivity extends AppCompatActivity {

    ImageButton ibAstronomicImageBack, ibShareImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronomic_image_of_the_day);
        bindViews();

        ibAstronomicImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ibShareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO esperar ensinar sobre compartilhamento nas redes sociais
            }
        });
    }

    private void bindViews() {
        ibAstronomicImageBack = findViewById(R.id.ibAstronomicImageBack);
        ibShareImage = findViewById(R.id.ibShareImage);
    }
}
