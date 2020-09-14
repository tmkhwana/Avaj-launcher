package com.tmkhwana.transport;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite extends AircraftFactory {
    public static ArrayList<String> MESSAGES = new ArrayList<>();

    public int positiveIntTryParse(String value) throws NumberFormatException{
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

    public ArrayList<String> readScenario(String scenario){
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
