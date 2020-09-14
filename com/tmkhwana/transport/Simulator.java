package com.tmkhwana.transport;

import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        ReadWrite r = new ReadWrite();
        ArrayList<String> scenarios = r.readScenario(args[0]);
        String type, name;
        WeatherTower weatherTower = new WeatherTower();
        int longitude, latitude, height;

        try {
            int simulations = r.positiveIntTryParse(scenarios.get(0));
            String[] line;
            for (int i = 1; i < scenarios.size(); i++){
                line = scenarios.get(i).split("\\s+");
                if (line.length == 5) {
                    type = line[0];
                    name = line[1];
                    longitude = r.positiveIntTryParse(line[2]);
                    latitude = r.positiveIntTryParse(line[3]);
                    height = r.positiveIntTryParse(line[4]);

                    AircraftFactory.newAircraft(type, name, longitude, latitude, height).registerTower(weatherTower);
                }
                else {
                    throw new Exception("Invalid Aircraft Info");
                }
            }

            for (int i = 0; i <= simulations; i++){
                weatherTower.changeWeather();
            }
            ReadWrite.writeSimulation();
            System.out.println("Programme Complete... Check simulation.txt");
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}
