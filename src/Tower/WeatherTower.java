package Tower;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import Aircrafts.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void ChangeWeather() {
        /*creates weather*/
        throw new NotImplementedException();
    }
}
