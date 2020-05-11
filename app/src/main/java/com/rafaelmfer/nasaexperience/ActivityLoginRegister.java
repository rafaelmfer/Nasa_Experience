package com.rafaelmfer.nasaexperience;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ActivityLoginRegister extends AppCompatActivity implements ActivityContract {

    FragmentManager fragManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        startFragment(new FragmentLogin());
    }

    @Override
    public void startFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContainer, fragment);
        fragmentTransaction.commit();
    }
}
