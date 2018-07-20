package Tower;

import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;

import java.io.*;

public class MainSims {
    public static void main(String[] args) {
        File inFile;
        String fileName;
        String ext;
        String line;
        String writeTo = "Simulator.txt";
        BufferedReader br = null;
        WeatherTower overWatch = new WeatherTower();
        Flyable flyMachine;

        int lineNb = 1;

        if (args.length == 1) {
            inFile = new File(args[0]);

            fileName = inFile.getName();
            int indexOfExt = fileName.lastIndexOf('.');

            ext = fileName.substring(indexOfExt + 1);

            //Cannot interpret MD5 yet
            if (!(ext.equals("txt"))) {
                System.out.println("Extension is not supported... Only txt is supported");
                System.exit(0);
            }

            try {
                br = new BufferedReader(new FileReader(inFile));

                int sims = 0;

                while ((line = br.readLine()) != null){
                    if (lineNb == 1){
                        sims = Integer.parseInt(line);
                        if (sims < 1){
                            System.out.println("You need to run at least one simulation.");
                            break;
                        }
                    }else{
                        try{
                            //Sending the specs to create each aircraft accordingly
                            if (lineNb > 0){
                                    getProps(line, overWatch);
                            }
                        }
                        catch (NumberFormatException toInt_ex){
                            System.out.println("Cannot find or convert to int coordinates on line " + lineNb);
                            continue;
                        }
                    }
                    lineNb++;
                }
                System.out.println("\n");
                while (sims-- > 0){
                    overWatch.ChangeWeather();
                }
            }
            catch (FileNotFoundException fnf_ex){
                System.out.println(fnf_ex.getMessage() + " The file was not found");
            }
            catch (IOException io_ex){
                System.out.println("Error: Unable to read line " + lineNb);
            }
        }else{
            System.out.println("This program takes 1 and only one argument from the command line! Program ending now");
            System.exit(0);
        }
    }

    private static void getProps(String line, WeatherTower overWatch) {
        Flyable flyMachine;
        String[]    sendToFactory   =   line.split(" ");
        String      type            =   sendToFactory[0];
        String      name            =   sendToFactory[1];
        int         longitude       =   Integer.parseInt(sendToFactory[2]);
        int         latitude        =   Integer.parseInt(sendToFactory[3]);
        int         height          =   Integer.parseInt(sendToFactory[4]);

        if (!(type.equals("Baloon") || type.equals("JetPlane") ||type.equals("Helicopter") )) {
            System.out.println(type + " is an unknown type. Exiting program now");
        }else {
            //create aircraft
            flyMachine = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
            //Register to tower.
            flyMachine.registerTower(overWatch);
        }
    }
}

