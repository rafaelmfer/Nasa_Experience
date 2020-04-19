package com.rafaelmfer.nasaexperience;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout tilLoginUserEmail, tilLoginUserPassword;
    EditText etLoginUserEmail, etLoginUserPassword;
    Button btLogin, btFacebookSignIn, btGoogleSignIn, btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tilLoginUserEmail.setError(null);
                tilLoginUserPassword.setError(null);
                if (editTextIsNotEmpty(etLoginUserEmail, etLoginUserPassword)) {
                    startActivity(new Intent(view.getContext(), HomeActivity.class));
                } else {
                    if (!editTextIsNotEmpty(etLoginUserEmail)) {
                        tilLoginUserEmail.setError(getString(R.string.error_field_must_be_filled));
                    }
                    if (!editTextIsNotEmpty(etLoginUserPassword)) {
                        tilLoginUserPassword.setError(getString(R.string.error_field_must_be_filled));
                    }
                }
            }
        });

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindViews() {
        tilLoginUserEmail = findViewById(R.id.tilLoginUserEmail);
        tilLoginUserPassword = findViewById(R.id.tilLoginUserPassword);
        etLoginUserEmail = findViewById(R.id.etLoginUserEmail);
        etLoginUserPassword = findViewById(R.id.etLoginUserPassword);
        btLogin = findViewById(R.id.btLogin);
        btFacebookSignIn = findViewById(R.id.btFacebookSignIn);
        btGoogleSignIn = findViewById(R.id.btGoogleSignIn);
        btSignUp = findViewById(R.id.btSignUp);
    }

    private boolean editTextIsNotEmpty(EditText... editTexts) {
        for (EditText et : editTexts) {
            if (et.getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
