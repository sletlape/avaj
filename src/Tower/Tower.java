package Tower;

import Aircrafts.Flyable;
import java.util.*;

public class Tower {
    ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unrggitster(Flyable flyable){
        observers.remove(flyable);
    }

    protected void  conditionsChanged() {

        for (Flyable flyable: observers) {
            flyable.updateConditions();
        }
    }
}
