package com.tmkhwana.transport;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;

        if (longitude < 0)
            this.longitude = 0;
        if (latitude < 0)
            this.latitude = 0;
        if (height < 0)
            this.height = 0;
        if (height > 100)
            this.height = 100;
    }

    public int getLongitude()
    {
        return this.longitude;
    }
    public int getLatitude()
    {
        return this.latitude;
    }
    public int getHeight()
    {
        return this.height;
    }
}
