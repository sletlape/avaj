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
            case "SUN":     System.out.println("Its too hot... Going up (+4) and east (+2)");
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":    System.out.println("I can't stand the rain, Going down (-5)");
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":     System.out.println("Ouch, this for hurts... Going down (-3)");
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "Snow":    System.out.println("Okay, this is getting bad... Going down (-15)");
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
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
