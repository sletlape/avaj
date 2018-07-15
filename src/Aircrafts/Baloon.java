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
            case "RAIN":    this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":     this.coordinates.setLongitude(this.coordinates.getLongitude() + 3);
                break;
            case "Snow":    this.coordinates.setHeight(this.coordinates.getHeight() + 15);
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
