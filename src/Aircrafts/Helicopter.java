package Aircrafts;

import Tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("My ID is: "+super.id);
    }

    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);
        switch (weather){
            case "SUN":     this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                            break;
            case "RAIN":    this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                            break;
            case "FOG":     this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                            break;
            case "Snow":    this.coordinates.setHeight(this.coordinates.getHeight() + 12);
                            break;
        }
    }

    public void registerTower(WeatherTower weatherTower){

        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
