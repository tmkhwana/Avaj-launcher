package com.tmkhwana.transport;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    protected JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String apply = "JetPlane#" + this.name + "(" + this.id + "): ";

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            ReadWrite.MESSAGES.add(apply + "It's blazing HOT!!");
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
            ReadWrite.MESSAGES.add(apply + "The rain is too much!!");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
            ReadWrite.MESSAGES.add(apply + "I cannot see i am gonna hit the clouds!!");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
            ReadWrite.MESSAGES.add(apply + "its cold up here!!");
        }

        if (coordinates.getHeight() <= 0){
            weatherTower.unregister(this);
            ReadWrite.MESSAGES.add("Tower says: JetPlane#" + this.name + "(" + this.id + "): Unregistered to the Tower");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        ReadWrite.MESSAGES.add("Tower says: JetPlane#" + this.name + "(" + this.id + "): Registered to the Tower");
    }
}
