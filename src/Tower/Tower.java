package Tower;

import Aircrafts.Aircraft;
import Aircrafts.Flyable;
import Outputs.WriteToSimFile;

import java.io.IOException;
import java.util.*;

public class Tower {
    ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        observers.add(flyable);
        Aircraft flyReg = (Aircraft)flyable;

        try {
            WriteToSimFile data = new WriteToSimFile("Simulator.txt", true);
            data.writeToFile("Tower says: " + flyReg.getType() + "#" + flyReg.getName() + "(" + flyReg.getId() + ") registered to Weather tower");
        }catch (IOException exWriting){
            System.out.println(exWriting + ": Error writing to file");
        }
    }

    public void unregitster(Flyable flyable){
        observers.remove(flyable);
        Aircraft flyUnReg = (Aircraft)flyable;

        try {
            WriteToSimFile data = new WriteToSimFile("Simulator.txt", true);
            data.writeToFile("Tower says: " + flyUnReg.getType() + "#"+flyUnReg.getName()+"("+flyUnReg.getId()+") unregistered from Weather tower");
        }catch (IOException exWriting){
            System.out.println(exWriting + ": Error writing to file");
        }
    }

    protected void  conditionsChanged() {

        for (int i =0; i< observers.size();i++)
        {
            Aircraft air = (Aircraft)observers.get(i);
            observers.get(i).updateConditions();

            if (!observers.contains(air))
                i--;
        }

        if (observers.size() == 0) {
            try {
                WriteToSimFile data = new WriteToSimFile("Simulator.txt", true);
                data.writeToFile("\nAll aircrafts have landed successfully!");
            }catch (IOException exWriting){
                System.out.println(exWriting + ": Error writing to file");
            }
            System.exit(0);
        }
    }
}
