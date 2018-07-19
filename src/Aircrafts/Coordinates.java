package Aircrafts;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        if(longitude < 0)
            longitude = 0;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        if (latitude < 0)
            latitude = 0;
        this.latitude = latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 100)
            height = 100;
        if (height < 0)
            height = 0;
        this.height = height;
    }
}
