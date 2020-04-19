package com.rafaelmfer.nasaexperience;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    ImageButton btRegisterBack;
    TextInputLayout tilRegisterUserName, tilRegisterUserLastName, tilRegisterUserEmail, tilRegisterUserPassword;
    EditText etRegisterUserName, etRegisterUserLastName, etRegisterUserEmail, etRegisterUserPassword;
    Button btCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindViews();

        btRegisterBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeErrorOnTextInputLayout(tilRegisterUserName, tilRegisterUserLastName, tilRegisterUserEmail, tilRegisterUserPassword);
                if (editTextIsNotEmpty(etRegisterUserName, etRegisterUserLastName, etRegisterUserEmail, etRegisterUserPassword)) {
                    startActivity(new Intent(view.getContext(), HomeActivity.class));
                } else {
                    if (!editTextIsNotEmpty(etRegisterUserName)) {
                        tilRegisterUserName.setError(getString(R.string.error_field_must_be_filled));
                    }
                    if (!editTextIsNotEmpty(etRegisterUserLastName)) {
                        tilRegisterUserLastName.setError(getString(R.string.error_field_must_be_filled));
                    }
                    if (!editTextIsNotEmpty(etRegisterUserEmail)) {
                        tilRegisterUserEmail.setError(getString(R.string.error_field_must_be_filled));
                    }
                    if (!editTextIsNotEmpty(etRegisterUserPassword)) {
                        tilRegisterUserPassword.setError(getString(R.string.error_field_must_be_filled));
                    }
                }
            }
        });
    }

    private void bindViews() {
        tilRegisterUserName = findViewById(R.id.tilRegisterUserName);
        tilRegisterUserLastName = findViewById(R.id.tilRegisterUserLastName);
        tilRegisterUserEmail = findViewById(R.id.tilRegisterUserEmail);
        tilRegisterUserPassword = findViewById(R.id.tilRegisterUserPassword);
        etRegisterUserName = findViewById(R.id.etRegisterUserName);
        etRegisterUserLastName = findViewById(R.id.etRegisterUserLastName);
        etRegisterUserEmail = findViewById(R.id.etRegisterUserEmail);
        etRegisterUserPassword = findViewById(R.id.etRegisterUserPassword);
        btRegisterBack = findViewById(R.id.ibRegisterBack);
        btCreateAccount = findViewById(R.id.btCreateAccount);
    }

    private boolean editTextIsNotEmpty(EditText... editTexts) {
        for (EditText et : editTexts) {
            if (et.getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void removeErrorOnTextInputLayout(TextInputLayout... textInputLayouts) {
        for (TextInputLayout til : textInputLayouts) {
            til.setError(null);
        }
    }
}
