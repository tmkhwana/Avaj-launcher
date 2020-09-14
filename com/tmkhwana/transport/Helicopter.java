package com.tmkhwana.transport;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String apply = "Helicopter#" + this.name + "(" + this.id + "): ";

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            ReadWrite.MESSAGES.add(apply + "It's blazing HOT!!");
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 5, coordinates.getLatitude(), coordinates.getHeight());
            ReadWrite.MESSAGES.add(apply + "The rain is too much!!");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 1, coordinates.getLatitude(), coordinates.getHeight());
            ReadWrite.MESSAGES.add(apply + "I cannot see i am gonna hit the clouds!!");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            ReadWrite.MESSAGES.add(apply + "its cold up here!!");
        }

        if (coordinates.getHeight() <= 0){
           weatherTower.unregister(this);
            ReadWrite.MESSAGES.add("Tower says: Helicopter#" + this.name + "(" + this.id + "): Unregistered to the Tower");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        ReadWrite.MESSAGES.add("Tower says: Helicopter#" + this.name + "(" + this.id + "): Registered to the Tower");
    }
}
