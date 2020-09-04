package com.tmkhwana.transport;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){

        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    private void changeWeather() {
        this.conditionsChanged();
    }
}
