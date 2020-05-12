package com.rafaelmfer.nasaexperience.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.ui.adapter.AdapterAsteroids;
import com.rafaelmfer.nasaexperience.model.AsteroidModel;
import com.rafaelmfer.nasaexperience.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityAsteroidsNearFromEarth extends AppCompatActivity {

    private RecyclerView rvSunsOfMars;
    public List<AsteroidModel> asteroids = new ArrayList<>();

    ImageButton ibAsteroidsBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asteroids_near_from_earth);

        ibAsteroidsBack = findViewById(R.id.asteroids_back);
        ibAsteroidsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rvSunsOfMars = findViewById(R.id.asteroids_near);
        //Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvSunsOfMars.setLayoutManager(layoutManager);
        //Define Adapter
        setupListAsteroid();
        AdapterAsteroids asteroidsAdapter = new AdapterAsteroids(asteroids);
        rvSunsOfMars.setAdapter(asteroidsAdapter);
    }

    public void setupListAsteroid() {

        asteroids.add(new AsteroidModel("Primeiro Asteroide", "Esse é rápido!"));
        asteroids.add(new AsteroidModel("Segundo Asteroide", "Multa!"));
        asteroids.add(new AsteroidModel("Terceiro Asteroide", "Mais ou menos"));
        asteroids.add(new AsteroidModel("Quarto Asteroide", "Brilha brilha estrelinha"));
        asteroids.add(new AsteroidModel("Quinto Asteroide", "Meteoro de Pegasus!"));
        asteroids.add(new AsteroidModel("Sexto Asteroide", "Vênu(s)"));
        asteroids.add(new AsteroidModel("Sétimo Asteroide", "Lobo homem?"));
        asteroids.add(new AsteroidModel("Oitavo Asteroide", "É 'preda'!"));
        asteroids.add(new AsteroidModel("Nono Asteroide", "Nhonho!!"));
        asteroids.add(new AsteroidModel("Décimo Asteroide", "Teste ok!"));

    }
}
