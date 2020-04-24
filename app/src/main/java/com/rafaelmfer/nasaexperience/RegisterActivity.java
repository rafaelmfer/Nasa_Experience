package com.rafaelmfer.nasaexperience;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    ImageButton btRegisterBack;
    Button btCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btRegisterBack = findViewById(R.id.btRegisterBack);
        btCreateAccount = findViewById(R.id.btCreateAccount);

        btRegisterBack.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               onBackPressed();
           }
        });

        btCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });
    }
}
