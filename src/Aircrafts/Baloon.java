package Aircrafts;

import Outputs.WriteToSimFile;
import Tower.WeatherTower;

import java.io.IOException;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        try {
            WriteToSimFile data = new WriteToSimFile("Simulator.txt", true);
            switch (weather) {
                case "SUN":
                    data.writeToFile(this.getType() + "#" + this.getName() + "(" + this.getId() + "): Its too hot... Going up (+4) and Longitude (+2)");
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                    this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                    break;
                case "RAIN":
                    data.writeToFile(this.getType() + "#" + this.getName() + "(" + this.getId() + "): I can't stand the rain, Going down (-5)");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                    break;
                case "FOG":
                    data.writeToFile(this.getType() + "#" + this.getName() + "(" + this.getId() + "): Ouch, this for hurts... Going down (-3)");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                    break;
                case "SNOW":
                    data.writeToFile(this.getType() + "#" + this.getName() + "(" + this.getId() + "): Okay, this is getting bad... Going down (-15)");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                    break;
            }
            if (this.coordinates.getHeight() == 0) {
                data.writeToFile(this.type + "#" + this.name + "(" + this.id + ") is landing");
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
