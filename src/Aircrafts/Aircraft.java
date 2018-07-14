package Aircrafts;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter = 0;

    public Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id++;
    }

    private long nextId(){
        return this.idCounter++;
    }

    ///verify this shit
}
