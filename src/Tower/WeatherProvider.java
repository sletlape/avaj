package Tower;

import Aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    static private WeatherProvider weatherProvider;
    static private String[] weather;

    private WeatherProvider(){
        weather = new String[] {"Fog","Rain","Snow","Sun"};
    }

    static public WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(weather.length);
        String randomWeather =  weather[randomNumber];

        if ((coordinates.getHeight() > 50) && (coordinates.getLatitude() < 20) && (coordinates.getLongitude() > 5)){
            return randomWeather.equals("Fog") ? getCurrentWeather(coordinates) : randomWeather;
        }

        if ((coordinates.getHeight() < 30) && (coordinates.getLatitude() > 45) && (coordinates.getLongitude() > 5)){
            return randomWeather.equals("Rain") ? getCurrentWeather(coordinates) : randomWeather;
        }
            return randomWeather;

    }
}
