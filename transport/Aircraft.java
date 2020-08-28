package com.tmkhwana.transport;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;
    protected Aircraft (String name , Coordinates coordinates){

    }
    private long nextId;
}
