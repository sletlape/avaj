package Tower;

import Aircrafts.Aircraft;
import Aircrafts.Flyable;
import java.util.*;

public class Tower {
    ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        observers.add(flyable);
        Aircraft flyReg = (Aircraft)flyable;
        System.out.println("Tower says: " + flyReg.getType() + "#"+flyReg.getName()+"("+flyReg.getId()+") registered to Weather tower");
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
