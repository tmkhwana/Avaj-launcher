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
            longitude = 0;
        if (latitude < 0)
            latitude = 0;
        if (height < 0)
            height = 0;
        if (height > 100)
            height = 100;
    }

    public int getLongitude()
    {
        //return this.longitude;
        return longitude;
    }
    public int getLatitude()
    {
    //    return this.latitude;
        return latitude;
    }
    public int getHeight()
    {
        //return this.height;
        return height;

    }
}
