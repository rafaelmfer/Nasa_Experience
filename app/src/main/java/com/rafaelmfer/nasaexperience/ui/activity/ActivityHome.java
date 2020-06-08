package com.rafaelmfer.nasaexperience.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.rafaelmfer.nasaexperience.R;

import org.jetbrains.annotations.NotNull;

public class ActivityHome extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    ImageButton ibMenu;
    Button btMarsWeather, btAsteroids, btAstronomicImage;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FragmentManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_content);
        bindViews();

        ibMenu = findViewById(R.id.ibMenu);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
        manager = getSupportFragmentManager();

        ibMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
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
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorites:
                Toast.makeText(this,"Me faz a " + "Lei Audio" + "!",Toast.LENGTH_LONG).show();
                break;
            case R.id.logout:
                Toast.makeText(this,"Me faz um LÊ ALTO!",Toast.LENGTH_LONG).show();
                break;
            case R.id.rateus:
                Toast.makeText(this,"Me faz um Le'ato!",Toast.LENGTH_LONG).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    public void vaPara(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }
}
