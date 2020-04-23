package com.rafaelmfer.nasaexperience.extensions;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class Utils {

    public static boolean editTextIsNotEmpty(EditText... editTexts) {
        for (EditText et : editTexts) {
            if (et.getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void removeErrorOnTextInputLayout(TextInputLayout... textInputLayouts) {
        for (TextInputLayout til : textInputLayouts) {
            til.setError(null);
        }
    }
}
