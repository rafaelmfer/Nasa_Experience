package com.rafaelmfer.nasaexperience;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterFragment extends Fragment {

    private ImageButton btRegisterBack;
    private TextInputLayout tilRegisterUserName, tilRegisterUserLastName, tilRegisterUserEmail, tilRegisterUserPassword;
    private EditText etRegisterUserName, etRegisterUserLastName, etRegisterUserEmail, etRegisterUserPassword;
    private Button btCreateAccount;

    private LoginRegisterInterface activity;

    public RegisterFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (LoginRegisterInterface) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);

        btRegisterBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onBackPressed();
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

    private void bindViews(View view) {
        tilRegisterUserName = view.findViewById(R.id.tilRegisterUserName);
        tilRegisterUserLastName = view.findViewById(R.id.tilRegisterUserLastName);
        tilRegisterUserEmail = view.findViewById(R.id.tilRegisterUserEmail);
        tilRegisterUserPassword = view.findViewById(R.id.tilRegisterUserPassword);
        etRegisterUserName = view.findViewById(R.id.etRegisterUserName);
        etRegisterUserLastName = view.findViewById(R.id.etRegisterUserLastName);
        etRegisterUserEmail = view.findViewById(R.id.etRegisterUserEmail);
        etRegisterUserPassword = view.findViewById(R.id.etRegisterUserPassword);
        btRegisterBack = view.findViewById(R.id.ibRegisterBack);
        btCreateAccount = view.findViewById(R.id.btCreateAccount);
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
