package Aircrafts;

import Tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);
        switch (weather){
            case "SUN":     this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":    this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":     this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "Snow":    this.coordinates.setHeight(this.coordinates.getHeight() + 7);
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
