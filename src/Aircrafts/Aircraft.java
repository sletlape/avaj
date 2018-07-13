package Aircrafts;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter;

    public Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId(){
        return this.idCounter+1;
    }

    ///verify this shit
}
