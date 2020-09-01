package com.tmkhwana.transport;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite {
    public static ArrayList<String> MESSAGES = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<String> scenarios = readScenario(args[0]);

//        for(String line: scenarios){
//            System.out.println(line);
//        }





        String s = writeSimulation();
        System.out.println(s);
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
