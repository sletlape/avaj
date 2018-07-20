package Aircrafts;

import Tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
       // System.out.print(this.name + "@ coordinates: Lat-"+ coordinates.getLatitude()+" Long-" +coordinates.getLongitude()+ " Height-"+coordinates.getHeight() +" " + weather + " ");
        switch (weather){
            case "SUN":     System.out.println(this.getType() + "#"+this.getName()+"("+this.getId()+"): Its too hot... Going up (+4) and Longitude (+2)");
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":    System.out.println(this.getType() + "#"+this.getName()+"("+this.getId()+"): I can't stand the rain, Going down (-5)");
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":     System.out.println(this.getType() + "#"+this.getName()+"("+this.getId()+"): Ouch, this for hurts... Going down (-3)");
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "SNOW":    System.out.println(this.getType() + "#"+this.getName()+"("+this.getId()+"): Okay, this is getting bad... Going down (-15)");
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
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
