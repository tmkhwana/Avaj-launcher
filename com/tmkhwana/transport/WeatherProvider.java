package com.tmkhwana.transport;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();

    private static String[] weather;

    private WeatherProvider(){
        this.weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};
    }

    public  static WeatherProvider getProvider()
    {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather (Coordinates coordinates){
        int getPosition = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        return weather[getPosition % 4];
    }

}
