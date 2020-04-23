package com.rafaelmfer.nasaexperience;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class LoginRegisterActivity extends AppCompatActivity implements LoginRegisterInterface {

    FragmentManager fragManager = getSupportFragmentManager();
//    Fragment loginFragment;
//    Fragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
//        loginFragment = fragManager.findFragmentById(R.id.fragLogin);
    }

    @Override
    public void startRegisterFragment() {

        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragLogin, new RegisterFragment());
        fragmentTransaction.commit();
    }
}
