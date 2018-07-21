package Aircrafts;

import Outputs.WriteToSimFile;
import Tower.WeatherTower;

import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);

        try {
            WriteToSimFile data = new WriteToSimFile("Simulator.txt", true);
            switch (weather) {
                case "SUN":
                    data.writeToFile(this.getType() + "#"+this.getName()+"("+this.getId()+"): Nice and sunny... Height (+2) and Longitude (+10)");
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                    this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                    break;
                case "RAIN":    data.writeToFile(this.getType() + "#"+this.getName()+"("+this.getId()+"): I'm getting wet... Longitude (+5)");
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                    break;
                case "FOG":     data.writeToFile(this.getType() + "#"+this.getName()+"("+this.getId()+"): This stings... Longitude (+1)");
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                    break;
                case "Snow":    data.writeToFile(this.getType() + "#"+this.getName()+"("+this.getId()+"): This is no fly... Height (-12)");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                    break;
            }

            if (this.coordinates.getHeight() ==  0){
                data.writeToFile(this.type+"#"+this.name+"("+this.id+") is landing");
            }
        }catch (IOException exWriting){
            System.out.println(exWriting + ": Error writing to file");
        }

    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }


}
