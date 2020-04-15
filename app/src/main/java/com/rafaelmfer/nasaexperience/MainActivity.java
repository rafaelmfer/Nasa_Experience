package com.rafaelmfer.nasaexperience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.textEmail = findViewById(R.id.username);
        this.mViewHolder.textPassword = findViewById(R.id.password);
        this.mViewHolder.loginButton = findViewById(R.id.login_button):

        this.mViewHolder.loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_button) {
            Intent intent = new Intent(this,Home_Activity.class);
        }
    }

    private static class ViewHolder {
        EditText textEmail;
        EditText textPassword;
        Button loginButton;

    }
}
