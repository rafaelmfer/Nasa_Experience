package com.rafaelmfer.nasaexperience.modelMars;

import android.view.View;
import android.widget.TextView;

public class Posts {
    String tvSunsNumberMars;
    String tvDateObservationMars;
    int vDecoratorSuns;
    String tvWindSpeed;
    String tvTemperature;
    String tvPressure;

    public Posts() {
    }

    public Posts(String tvSunsNumberMars, String tvDateObservationMars, int vDecoratorSuns, String tvWindSpeed, String tvTemperature, String tvPressure) {
        this.tvSunsNumberMars = tvSunsNumberMars;
        this.tvDateObservationMars = tvDateObservationMars;
        this.vDecoratorSuns = vDecoratorSuns;
        this.tvWindSpeed = tvWindSpeed;
        this.tvTemperature = tvTemperature;
        this.tvPressure = tvPressure;
    }

    public String getTvSunsNumberMars() {
        return tvSunsNumberMars;
    }

    public void setTvSunsNumberMars(String tvSunsNumberMars) {
        this.tvSunsNumberMars = tvSunsNumberMars;
    }

    public String getTvDateObservationMars() {
        return tvDateObservationMars;
    }

    public void setTvDateObservationMars(String tvDateObservationMars) {
        this.tvDateObservationMars = tvDateObservationMars;
    }

    public int getvDecoratorSuns() {
        return vDecoratorSuns;
    }

    public void setvDecoratorSuns(int vDecoratorSuns) {
        this.vDecoratorSuns = vDecoratorSuns;
    }

    public String getTvWindSpeed() {
        return tvWindSpeed;
    }

    public void setTvWindSpeed(String tvWindSpeed) {
        this.tvWindSpeed = tvWindSpeed;
    }

    public String getTvTemperature() {
        return tvTemperature;
    }

    public void setTvTemperature(String tvTemperature) {
        this.tvTemperature = tvTemperature;
    }

    public String getTvPressure() {
        return tvPressure;
    }

    public void setTvPressure(String tvPressure) {
        this.tvPressure = tvPressure;
    }
}
