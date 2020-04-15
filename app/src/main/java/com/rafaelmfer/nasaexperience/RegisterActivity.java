package com.rafaelmfer.nasaexperience;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    ImageButton btRegisterBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btRegisterBack = findViewById(R.id.btRegisterBack);

        btRegisterBack.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               onBackPressed();
           }
        });
    }
}
