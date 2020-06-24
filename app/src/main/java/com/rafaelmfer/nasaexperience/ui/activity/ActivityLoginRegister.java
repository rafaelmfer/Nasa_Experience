package com.rafaelmfer.nasaexperience.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.rafaelmfer.nasaexperience.R;
import com.rafaelmfer.nasaexperience.ui.fragments.FragmentLogin;

import org.jetbrains.annotations.NotNull;

public class ActivityLoginRegister extends AppCompatActivity implements ActivityContract {

    FragmentManager fragManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startFragment(new FragmentLogin());
    }

    @Override
    public void startFragment(Fragment fragment) {
        boolean fragBack = hasThisFragment(fragManager, fragment.getClass().getName());

        if (!fragBack) fragManager
                .beginTransaction()
                .replace(R.id.flContainer, fragment)
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }

    private static boolean hasThisFragment(FragmentManager fragManager, String fragName) {
        return fragManager.popBackStackImmediate(fragName, 0);
    }

    @Override
    public void onBackPressed() {
        Fragment selectedFragment = null;
        for (Fragment fragment : fragManager.getFragments()) {
            if (fragment.isVisible()) {
                selectedFragment = fragment;
                break;
            }
            return;
        }
        if (selectedFragment instanceof FragmentLogin) {
            finish();
        } else {
            startFragment(new FragmentLogin());
        }
    }

    @NotNull
    @Override
    public Activity getActivity() {
        return this;
    }
}