package com.tmkhwana.transport;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
        try {
            switch (type) {
                case "Baloon":
                    return new Baloon(name, new Coordinates(longitude, latitude, height));
                case "JetPlane":
                    return new JetPlane(name, new Coordinates(longitude, latitude, height));
                case "Helicopter":
                    return new Helicopter(name, new Coordinates(longitude, latitude, height));
                default:
                    throw new Exception("Invalid aircraft type detected!!!");
            }

        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
