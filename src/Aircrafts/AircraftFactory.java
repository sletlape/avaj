package Aircrafts;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Helicopter")) {
            Helicopter tmpH = new Helicopter(name, coordinates);
            tmpH.setType(type);
            return tmpH;
        }
        if (type.equals("Baloon")) {
            Baloon tmpB = new Baloon(name, coordinates);
            tmpB.setType(type);
            return tmpB;
        }
        if (type.equals("JetPlane")) {
            JetPlane tmpJ = new JetPlane(name, coordinates);
            tmpJ.setType(type);
            return tmpJ;
        }
        return null;
    }
}
