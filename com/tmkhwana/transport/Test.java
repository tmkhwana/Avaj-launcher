package com.tmkhwana.transport;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {

    public void tester(String scenario){
        try {
            FileReader object = new FileReader(scenario);
            BufferedReader reader = new BufferedReader(object);
            String data = reader.readLine();
            while (data != null){
                ReadWrite.MESSAGES.add(data);
                data = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
