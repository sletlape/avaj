package Tower;

import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;
import Outputs.WriteToSimFile;

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

        int simsLine = 0;
        int lineNb = 0;

        if (args.length == 1) {
            inFile = new File(args[0]);

            fileName = inFile.getName();
            int indexOfExt = fileName.lastIndexOf('.');

            ext = fileName.substring(indexOfExt + 1);

            //Checking if file has proper extension
            fileType(ext);

            try {//create a file to write to
                WriteToSimFile makeNew = new WriteToSimFile( writeTo);
                WriteToSimFile data = new WriteToSimFile( writeTo, true );
                //Make blank file
                makeNew.writeToFile("");
                br = new BufferedReader(new FileReader(inFile));
                //for checking which line the number of sims is on
                int sims = 0;

                while ((line = br.readLine()) != null) {
                    String[]    sendToFactory   =   line.split(" ");
                    String      type            =   sendToFactory[0];
                    Boolean     typeError       =   true;

                    if(type.equals("Baloon") || type.equals("JetPlane") ||type.equals("Helicopter"))
                        typeError = false;
                    lineNb++;
                    if (!line.equals("")){
                        if (simsLine == 0 ) {
                            //Get sims in this if
                            if (!typeError && sims == 0) {
                                break;
                            }
                            //figure out how to get number of sims on any line
                            if (isNumber(line)) {
                                sims = Integer.parseInt(line);
                            }
                            else {
                                continue;
                            }//Writing to file
                            data.writeToFile("Simulations to be conducted = "+sims+"\n");
                            simsLine = lineNb;
                        }else if (simsLine > 0){
                            try{//Sending the specs to create each aircraft accordingly
                                if (lineNb > 0){
                                    if (typeError) {
                                        System.out.println("Line "+lineNb+" is not recognised... cannot manufacture "+type+"\n");
                                        continue;
                                    }
                                    getProps(line, overWatch, lineNb);
                                }
                            }
                            catch (NumberFormatException toInt_ex){
                                System.out.println("Cannot find or convert to int coordinates on line " + lineNb+"\n");
                                continue;
                            }
                        }
                    }else{
                        continue;
                    }
                }
                simulate(overWatch, data, sims);
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

    private static void simulate(WeatherTower overWatch, WriteToSimFile data, int sims) throws IOException {
        if (sims < 1){
            System.out.println("You need to run at least one simulation Before creating aircrafts... Bye!!!");
        }
        for (int i = 1; i <= sims; i++){
            data.writeToFile( "\n==============================");
            data.writeToFile( "    Simulation number "+i);
            data.writeToFile( "==============================");

            overWatch.ChangeWeather();
        }
        System.out.println("**********************************");
        System.out.println("Done with all " +sims+ " simulations!!!");
        System.out.println("Results printed to Simulator file");
        System.out.println("**********************************");
    }

    private static void fileType(String ext) {
        if (!(ext.equals("txt"))) {
            System.out.println("Extension is not supported... Only txt is supported");
            System.exit(0);
        }
    }

    private static boolean isNumber(String line) {
        String str = line.replace(" ", "");
        for(int i = 0; i < str.length();i++)
            if(Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        return true;
    }

    private static void getProps(String line, WeatherTower overWatch, int lineNb) {
        Flyable flyMachine;
        String[]    sendToFactory   =   line.split(" ");

        if (sendToFactory.length > 5){
            System.out.println("Too many arguments on line "+ lineNb +". Plane will not be created.\n");
        }else{
            String      type            =   sendToFactory[0];
            String      name            =   sendToFactory[1];
            int         longitude       =   Integer.parseInt(sendToFactory[2]);
            int         latitude        =   Integer.parseInt(sendToFactory[3]);
            int         height          =   Integer.parseInt(sendToFactory[4]);

            if (!(type.equals("Baloon") || type.equals("JetPlane") ||type.equals("Helicopter") )) {
                System.out.println(type + " is an unknown type, it will not be created: Check Line " +lineNb);
            }else {
                //create aircraft
                flyMachine = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
                //Register to tower.
                flyMachine.registerTower(overWatch);
            }
        }
    }
}

