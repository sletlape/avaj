package Aircrafts;

import Tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather){
            case "SUN":     this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":    this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":     this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "Snow":    this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                break;
        }
        if (this.coordinates.getHeight() ==  0){
            System.out.println(this.type+"#"+this.name+this.id+" is landing");
            //weatherTower.unregitster(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
