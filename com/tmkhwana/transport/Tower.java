package com.tmkhwana.transport;

import java.util.List;

public abstract class Tower {
    private List <Flyable> observers;
    public void register(Flyable flyable){

    }
    public void unregister(Flyable flyable){

    }
    protected void conditionsChanged(){

    }
}
