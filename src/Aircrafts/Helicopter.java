package Aircrafts;

import Tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);
        switch (weather){
            case "SUN":     System.out.println("Its too hot... Height (+2) and Longitude (+10)");
                        this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                        break;
            case "RAIN":    System.out.println("I'm getting wet... Longitude (+5)");
                        this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                        break;
            case "FOG":     System.out.println("Its too hot... Going up (+4) and Longitude (+2)");
                        this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
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
