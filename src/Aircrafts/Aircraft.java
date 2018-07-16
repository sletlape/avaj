package Aircrafts;

public class Aircraft {
    protected long id;
    protected String type;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter = 1L;

    public Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private long nextId(){
        return this.idCounter++;
    }

    ///verify this shit

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
