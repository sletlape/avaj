package Aircrafts;

import Outputs.WriteToSimFile;
import Tower.WeatherTower;

import java.io.IOException;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);

        try {
            WriteToSimFile data = new WriteToSimFile("Simulator.txt", true);
            switch (weather){
                case "SUN":
                    data.writeToFile(this.getType() + "#"+this.getName()+"("+this.getId()+"): The weather today is a scorcher... Height (+2) and Longitude (+10)");
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                    this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                    break;
                case "RAIN":
                    data.writeToFile(this.getType() + "#"+this.getName()+"("+this.getId()+"): A little water can't touch me... Latitude (+5)");
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                    break;
                case "FOG":
                    data.writeToFile(this.getType() + "#"+this.getName()+"("+this.getId()+"): Don't dent my body work... Latitude (+1)");
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                    break;
                case "SNOW":
                    data.writeToFile(this.getType() + "#"+this.getName()+"("+this.getId()+"): Some things you just don't risk (-7)");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                    break;
            }
            if (this.coordinates.getHeight() ==  0){
                data.writeToFile(this.type+"#"+this.name+"("+this.id+") is landing");
                weatherTower.unregitster(this);
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
