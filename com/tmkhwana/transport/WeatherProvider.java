package com.tmkhwana.transport;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;

    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){

    }

    public  static WeatherProvider getProvider() {
        return weatherProvider;
    }
    public String getCurrentWeather (Coordinates coordinates){
        int getPosition = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        return weather[getPosition % 4];
    }

}
