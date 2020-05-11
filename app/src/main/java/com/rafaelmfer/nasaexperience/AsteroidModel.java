package com.rafaelmfer.nasaexperience;

public class AsteroidModel {

    private String asteroidNumber, asteroidDescription;

    public AsteroidModel() {
    }

    public AsteroidModel(String asteroidNumber, String asteroid) {
        this.asteroidNumber = asteroidNumber;
        this.asteroidDescription = asteroid;
    }

    public String getAsteroidNumber() {
        return asteroidNumber;
    }

    public void setAsteroidNumber(String asteroidNumber) {
        this.asteroidNumber = asteroidNumber;
    }

    public String getAsteroidDescription() {
        return asteroidDescription;
    }

    public void setAsteroidDescription(String asteroidDescription) {
        this.asteroidDescription = asteroidDescription;
    }
}
