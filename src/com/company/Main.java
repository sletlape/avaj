package com.company;

import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;
import Tower.WeatherTower;

import java.io.*;
/*import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
*/
public class Main {

    public static void main(String[] args) {
        File inFile;
        String fileName;
        String ext;
        String line;
        BufferedReader br = null;

       // System.out.println("Inside " + args[0]);

        if (args.length == 1){
            inFile = new File(args[0]);

            fileName = inFile.getName();
            int indexOfExt = fileName.lastIndexOf('.');

            ext = fileName.substring(indexOfExt+1);

            //Cannot interpret MD5 yet
            if (!(ext.equals("txt") || (ext.equals("md5")))){
                System.out.println("Extension is not supported... Only txt and MD5 is supported");
                System.exit(0);
            }

            try {
                br = new BufferedReader(new FileReader(inFile));
            }catch (FileNotFoundException fnf_ex){
                System.out.println(fnf_ex.getMessage() + " The file was not found");
                System.exit(0);
            }

            try {
                int i = 0;
                int sims;
                while ((line = br.readLine()) != null){
                    if (i == 0){
                        try {
                            sims = Integer.parseInt(line);
                            if (sims < 1){
                                System.out.println("You need to run at least one simulation.");
                                break;
                            }
                        }catch (Exception intParse_ex){
                            System.out.println(intParse_ex.getMessage() + " Unable to convert first line to int!");
                            break;
                        }
                    }

                    if (i > 0){

                        WeatherTower overWatch = new WeatherTower();
                        ///Split by spacing and send to factory to create flyMachine with initial values
                        String[] sendToFactory  =   line.split(" ");

                        String  type        =   sendToFactory[0];
                        String  name        =   sendToFactory[1];
                        int     longitude   =   Integer.parseInt(sendToFactory[2]);
                        int     latitude    =   Integer.parseInt(sendToFactory[3]);
                        int     height      =   Integer.parseInt(sendToFactory[4]);

                        //create aircraft
                        Flyable flyMachine = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
                        //Register to tower.
                        flyMachine.registerTower(overWatch);

                        //update supposed to be done on the tower... during the loop
                        flyMachine.updateConditions();
                    }
                    i++;
                    ///done creating flyMachines and counting them.;
                }
               /* //simulate conditions here on each .
                while (sims-- > 0){
                    System.out.println("Simulation number " + sims);
                    //update conditions for each flyMachine.
                    //use idCounter to alter conditions for all flyMachines.
                }
            */}catch (IOException io_ex){
                System.out.println(io_ex.getMessage() + " Unable to read line");
            }
        }else{
            System.out.println("This program takes 1 and only one argument from the command line!");
        }
    }
 }