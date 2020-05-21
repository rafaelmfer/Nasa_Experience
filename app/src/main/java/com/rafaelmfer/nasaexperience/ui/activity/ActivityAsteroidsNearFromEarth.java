package com.rafaelmfer.nasaexperience.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.model.AsteroidModel;
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterAsteroids;
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

        asteroids.add(new AsteroidModel(0, "Primeiro Asteroide", "Esse é rápido!"));
        asteroids.add(new AsteroidModel(1, "Segundo Asteroide", "Multa!"));
        asteroids.add(new AsteroidModel(2, "Terceiro Asteroide", "Mais ou menos"));
        asteroids.add(new AsteroidModel(3, "Quarto Asteroide", "Brilha brilha estrelinha"));
        asteroids.add(new AsteroidModel(4, "Quinto Asteroide", "Meteoro de Pegasus!"));
        asteroids.add(new AsteroidModel(5, "Sexto Asteroide", "Vênu(s)"));
        asteroids.add(new AsteroidModel(6, "Sétimo Asteroide", "Lobo homem?"));
        asteroids.add(new AsteroidModel(7, "Oitavo Asteroide", "É 'preda'!"));
        asteroids.add(new AsteroidModel(8, "Nono Asteroide", "Nhonho!!"));
        asteroids.add(new AsteroidModel(9, "Décimo Asteroide", "Teste ok!"));

    }
}
