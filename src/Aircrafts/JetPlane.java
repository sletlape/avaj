package Aircrafts;

import Tower.WeatherTower;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        throw new NotImplementedException();
    }

    public void registerTower(WeatherTower weatherTower){
        throw new NotImplementedException();
    }
}
