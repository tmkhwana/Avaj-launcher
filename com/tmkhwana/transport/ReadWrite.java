package com.tmkhwana.transport;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite extends AircraftFactory {
    public static ArrayList<String> MESSAGES = new ArrayList<>();
    public static void main(String[] args) {
        ReadWrite r = new ReadWrite();
        ArrayList<String> scenarios = readScenario(args[0]);
        String type, name;
        int longitude, latitude, height;
        ArrayList<Flyable> aircrafts = new ArrayList<>();

        try {
            int simulations = positiveIntTryParse(scenarios.get(0));
            String line[];
            for (int i = 1; i < scenarios.size(); i++){
                line = scenarios.get(i).split(" ");
                if (line.length == 5) {
                    type = line[0];
                    name = line[1];
                    longitude = positiveIntTryParse(line[2]);
                    latitude = positiveIntTryParse(line[3]);
                    height = positiveIntTryParse(line[4]);

                    aircrafts.add(r.newAircraft(type, name, longitude, latitude, height));
                } else {
                    throw new Exception("Invalid Aircraft Info");
                }
            }

            for (Flyable f: aircrafts) {
                System.out.println(f);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }




//        String s = writeSimulation();
//        System.out.println(s);
    }

    public static int positiveIntTryParse(String value) throws NumberFormatException{
        int i;
        try {
            i  = Integer.parseInt(value);
        } catch (NumberFormatException e){
            throw new NumberFormatException("String in a place of int detected!!!");
        }
        if(i < 0){
            throw new NumberFormatException("Negative number detected!!!");
        }
        return i;
    }

    public static ArrayList<String> readScenario(String scenario){
        ArrayList<String> scenarios = new ArrayList<>();
        try {
            FileReader object = new FileReader(scenario);
            BufferedReader reader = new BufferedReader(object);
            String data = reader.readLine();
            while (data != null){
                scenarios.add(data);
                data = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scenarios;
    }

    public static String writeSimulation(){
        String filePath = "simulation.txt";
        try{
            FileWriter object = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(object);
            for(String message: MESSAGES){
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "successful";
    }
}
