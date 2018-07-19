package Tower;

import Aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    static private WeatherProvider weatherProvider;
    static private String[] weather;

    private WeatherProvider(){
        weather = new String[] {"FOG","RAIN","SNOW","SUN"};
    }

    static public WeatherProvider getProvider()
    {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(weather.length);

        String randomWeather =  weather[randomNumber];

        //filter types of weather at different coordinates recursively
        if ((coordinates.getHeight() > 50) && (coordinates.getLatitude() < 200) && (coordinates.getLongitude() < 15)){
            return randomWeather.equals("SNOW") ? getCurrentWeather(coordinates) : randomWeather;
        }

        if ((coordinates.getHeight() < 30) && (coordinates.getLatitude() > 45) && (coordinates.getLongitude() > 5)){
            return randomWeather.equals("RAIN") ? getCurrentWeather(coordinates) : randomWeather;
        }
        return randomWeather;
    }
}
