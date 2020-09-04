package com.tmkhwana.transport;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String cond = weatherTower.getWeather(this.coordinates);

        System.out.printf("%s");


        if (cond.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 2, coordinates.getLatitude() + 0, coordinates.getHeight() + 4);
            System.out.println(" Let's enjoy the Sun");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: Helicopter" + this.name);
    }
}
