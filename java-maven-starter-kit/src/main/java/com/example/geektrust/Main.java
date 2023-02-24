package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.example.geektrust.service.TotalExpense;
import com.example.geektrust.model.Inputs;
import com.example.geektrust.service.Summary;

public class Main {
    public static void main(String[] args) {
    	
        final String balance = "BALANCE";
        final String check = "CHECK_IN";
        final String summary = "PRINT_SUMMARY";

        Inputs input = new Inputs();
        TotalExpense totalExpence = new TotalExpense();
        Summary s = new Summary();

        //Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned

            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String str = sc.nextLine();
                String[] arguments = str.split(" ");

                if(arguments[0].equals(balance))
                    input.setdetailsOfCard(arguments);
                else if(arguments[0].equals(check))
                    input.setdetailsOFCheckIn(arguments);
                else if (arguments[0].equals(summary))
                    break;
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }

        totalExpence.totalCollection();
        s.centralSummaryPrint();
        s.airportSummaryPrint();
     }
}
