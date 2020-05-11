package com.rafaelmfer.nasaexperience;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import static com.rafaelmfer.nasaexperience.extensions.Utils.editTextIsNotEmpty;
import static com.rafaelmfer.nasaexperience.extensions.Utils.removeErrorOnTextInputLayout;

public class FragmentLogin extends Fragment {

    private TextInputLayout tilLoginUserEmail, tilLoginUserPassword;
    private EditText etLoginUserEmail, etLoginUserPassword;
    private Button btLogin, btFacebookSignIn, btGoogleSignIn, btSignUp;

    private InterfaceLoginRegister activity;

    public FragmentLogin() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (InterfaceLoginRegister) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeErrorOnTextInputLayout(tilLoginUserEmail, tilLoginUserPassword);
        if (editTextIsNotEmpty(etLoginUserEmail, etLoginUserPassword)) {
            startActivity(new Intent(view.getContext(), ActivityHome.class));
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
                activity.startFragment(new FragmentRegister());
            }
        });
    }

    private void bindViews(View view) {
        tilLoginUserEmail = view.findViewById(R.id.tilLoginUserEmail);
        tilLoginUserPassword = view.findViewById(R.id.tilLoginUserPassword);
        etLoginUserEmail = view.findViewById(R.id.etLoginUserEmail);
        etLoginUserPassword = view.findViewById(R.id.etLoginUserPassword);
        btLogin = view.findViewById(R.id.btLogin);
        btFacebookSignIn = view.findViewById(R.id.btFacebookSignIn);
        btGoogleSignIn = view.findViewById(R.id.btGoogleSignIn);
        btSignUp = view.findViewById(R.id.btSignUp);
    }
}
