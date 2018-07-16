package Aircrafts;

import Tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);


        System.out.println("The weather is "+weather);
        switch (weather){
            case "SUN":     this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                            break;
            case "RAIN":    this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                            break;
            case "FOG":     this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                            break;
            case "Snow":    this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                            break;
        }

        if (this.coordinates.getHeight() ==  0){
            System.out.println(this.type+"#"+this.name+"("+this.id+") is landing");

        }

    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }


}
