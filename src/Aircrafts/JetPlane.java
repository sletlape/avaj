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
            case "SUN": System.out.println(this.getType() + "#"+this.getName()+"("+this.getId()+"): The weather today is a scorcher... Height (+2) and Longitude (+10)");
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":    System.out.println(this.getType() + "#"+this.getName()+"("+this.getId()+"): A little water can't touch me... Latitude (+5)");
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG": System.out.println(this.getType() + "#"+this.getName()+"("+this.getId()+"): Don't dent my body work... Latitude (+1)");
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "Snow":    System.out.println(this.getType() + "#"+this.getName()+"("+this.getId()+"): Some things you just don't risk (-7)");
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
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
