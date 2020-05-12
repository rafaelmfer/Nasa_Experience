package com.rafaelmfer.nasaexperience.model;

public class MarsModel {

    private String sunNumber, sunDateObservation, sunTemperature, sunWindSpeed, sunPressure;

    public MarsModel() {
    }

    public MarsModel(String sunNumber, String sunDateObservation, String sunTemperature, String sunWindSpeed, String sunPressure) {
        this.sunNumber = sunNumber;
        this.sunDateObservation = sunDateObservation;
        this.sunTemperature = sunTemperature;
        this.sunWindSpeed = sunWindSpeed;
        this.sunPressure = sunPressure;
    }

    public String getSunNumber() {
        return sunNumber;
    }

    public void setSunNumber(String sunNumber) {
        this.sunNumber = sunNumber;
    }

    public String getSunDateObservation() {
        return sunDateObservation;
    }

    public void setSunDateObservation(String sunDateObservation) {
        this.sunDateObservation = sunDateObservation;
    }

    public String getSunTemperature() {
        return sunTemperature;
    }

    public void setSunTemperature(String sunTemperature) {
        this.sunTemperature = sunTemperature;
    }

    public String getSunWindSpeed() {
        return sunWindSpeed;
    }

    public void setSunWindSpeed(String sunWindSpeed) {
        this.sunWindSpeed = sunWindSpeed;
    }

    public String getSunPressure() {
        return sunPressure;
    }

    public void setSunPressure(String sunPressure) {
        this.sunPressure = sunPressure;
    }
}
