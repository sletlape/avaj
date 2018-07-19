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

    public void unregitster(Flyable flyable){
        observers.remove(flyable);
        Aircraft flyUnReg = (Aircraft)flyable;
        System.out.println("Tower says: " + flyUnReg.getType() + "#"+flyUnReg.getName()+"("+flyUnReg.getId()+") unregistered from Weather tower");
    }

    protected void  conditionsChanged() {

        /*Iterator<Flyable> iterator = observers.iterator();

        while (iterator.hasNext())
        {
            Flyable flyable = iterator.next();
            flyable.updateConditions();
            Aircraft air = (Aircraft)flyable;
            if (air.getCoordinates().getHeight() == 0) {
                iterator.remove();
                unregitster(flyable);
            }
        }*/
        for (int i =0; i< observers.size();i++)
        {
            observers.get(i).updateConditions();
            Aircraft air = (Aircraft)observers.get(i);
            if (air.getCoordinates().getHeight() == 0)
            {
                unregitster(observers.get(i));
                observers.remove(i);
                i--;
            }
        }



        if (observers.size() == 0) {
            System.out.println("\nAll aircrafts have landed successfully!");
            System.exit(0);
        }
    }
}
