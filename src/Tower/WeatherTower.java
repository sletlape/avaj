package Tower;


import Aircrafts.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void ChangeWeather() {
        conditionsChanged();
    }
}
