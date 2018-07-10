package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = null;
        String line;

        System.out.println("Please enter files directory!");

        try {
            br = new BufferedReader(new FileReader(scanner.next()));
        }catch (FileNotFoundException fnf_ex){
            System.out.println(fnf_ex.getMessage() + "The file was not found");
            System.exit(0);
        }

        try {
            while ((line = br.readLine()) != null)
            {
                System.out.println(line + "...\n");
            }
        }catch (IOException io_ex){
            System.out.println(io_ex.getMessage() + "Unable to read line");
        }
    }
 }