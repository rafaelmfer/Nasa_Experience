package com.rafaelmfer.nasaexperience;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityMarsWeatherSuns extends AppCompatActivity {

    private RecyclerView rvSunsOfMars;
    private List<MarsModel> suns = new ArrayList<>();

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

        rvSunsOfMars = findViewById(R.id.rvSunsOfMars);

        //Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvSunsOfMars.setLayoutManager( layoutManager );
        //Define adapter
        preparaSuns();
        AdapterMars adapterMars = new AdapterMars(suns);
        rvSunsOfMars.setAdapter( adapterMars);
    }

    public void preparaSuns(){

        this.suns.add(new MarsModel("Sol número 1","01/01/1971","-83ºC - (Levem blusa)","Velocidade - 50 Sonic's por hora","Pressão - Chorei no chuveiro =/"));

        this.suns.add(new MarsModel("Sol 2 ","01/01/1971","-21ºC - (Sou do Sul, dia normal!)","3 Papaléguas por hora","Prazos e mais prazos"));

        this.suns.add(new MarsModel("Sol 3","01/01/1971 (Foi um dia agitado)","-120ºC - (Vem nimim Titanic)","5 Icebergs por hora","Toca o violino!"));

        this.suns.add(new MarsModel("Sol 4","01/01/1971","43ºC - (Ta com kalor paulixxta? kkkk otário)","6 assaltos por minuto (Só nessa rua)","Passa o celular!"));

        this.suns.add(new MarsModel("Sol 7","01/01/1976","17ºC - (Spectrum Philadelphia)","15 minutos da minha casa (Rocky)","Apollo não consegue acreditar no que está vendo, nem nós também!"));

        this.suns.add(new MarsModel("Sol 6","01/01/1985","-9ºC - (Se morrer, morreu)","10km (Dragoo!)","Rocky parece um pedaço de ferro"));

        this.suns.add(new MarsModel("Sol 7","01/01/1985","-9ºC - (Se morrer, morreu)","10km (Dragoooooooooooo!)","A força do soviético é impressionante"));

        this.suns.add(new MarsModel("Sol 8","01/01/1985","-9ºC - (Essa é a Rússia? Não parece taõ ruim...)","10km (Dragooooo!)","Este homem pequeno é fisicamente incapaz de vencer Drago!"));
    }
}
