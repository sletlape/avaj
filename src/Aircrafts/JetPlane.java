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
            case "SUN":     this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":    this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG":     this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "Snow":    this.coordinates.setHeight(this.coordinates.getHeight() - 7);
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
