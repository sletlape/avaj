package Aircrafts;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Helicopter")) {
            System.out.println("Creating Helli");
            return (new Helicopter(name, coordinates));
        }
        if (type.equals("Baloon")) {
            System.out.println("Creating Balloon");
            return (new Baloon(name, coordinates));
        }
        if (type.equals("JetPlane")) {
            System.out.println("Creating Jet");
            return (new JetPlane(name, coordinates));
        }
        return null;
    }
}
