package com.tmkhwana.transport;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower{

    private List <Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }
    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }
    protected void conditionsChanged(){
        for (int i = 0; i < observers.size(); i++){
            observers.get(i).updateConditions();
        }
    }
}
