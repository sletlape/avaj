package com.company;

import java.io.*;
/*import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
*/
public class Main {

    public static void main(String[] args) {
        File inFile = null;
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
                    {//Split by spacing and send to factory
                        String[] sendToFactory = line.split(" ");
                        /*type*/System.out.println(sendToFactory[0]);
                        /*name*/System.out.println(sendToFactory[1]);
                        /*long*/System.out.println(sendToFactory[2]);
                        /*lati*/System.out.println(sendToFactory[3]);
                        /*high*/System.out.println(sendToFactory[4]);
                        /*Divide*/System.out.println(".........................");
                    }
                    i++;
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