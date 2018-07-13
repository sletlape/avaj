package com.company;

import Aircrafts.Aircraft;
import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;

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
        BufferedReader br = null;
        String line;

        System.out.println("Inside " + args[0]);

        if (args.length == 1)
        {
            inFile = new File(args[0]);
            try {
                br = new BufferedReader(new FileReader(inFile));
            }catch (FileNotFoundException fnf_ex){
                System.out.println(fnf_ex.getMessage() + " The file was not found");
                System.exit(0);
            }

            try {
                int i = 0;
                int sims = 0;
                while ((line = br.readLine()) != null)
                {
                    if (i == 0)
                    {
                        try {
                            sims = Integer.parseInt(line);
                        }catch (Exception intParse_ex){
                            System.out.println(intParse_ex.getMessage() + " Unabel to convert first line to int!");
                            break;
                        }
                    }

                    if (i > 0)
                    {///Split by spacing and send to factory to create flyMachine with initial values
                        String[] sendToFactory  =   line.split(" ");

                        String  type            =   sendToFactory[0];
                        String  name            =   sendToFactory[1];
                        int     longitude       =   Integer.parseInt(sendToFactory[2]);
                        int     latitude        =   Integer.parseInt(sendToFactory[3]);
                        int     height          =   Integer.parseInt(sendToFactory[4]);

                //        Flyable flyMachine = new AircraftFactory(type, name, longitude, latitude, height);

                        //testing
                        /*type*/System.out.println(type);
                        /*name*/System.out.println(name);
                        /*long*/System.out.println(longitude);
                        /*lati*/System.out.println(latitude);
                        /*high*/System.out.println(height);
                        /*Divide*/System.out.println(".........................");
                    }
                    i++;
                    ///done creating flyMachines;
                }
                //simulate conditions here on each .
                while (sims-- > 0)
                {
                    System.out.println("Simulation number " + sims);
                    //update conditions for each flyMachine.
                    //use idCounter to alter conditions for all flyMachines.
                }
            }catch (IOException io_ex){
                System.out.println(io_ex.getMessage() + " Unable to read line");
            }
        }
        else
        {
            System.out.println("Only 1 argument allowed");
        }
    }
 }