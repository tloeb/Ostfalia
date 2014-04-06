package de.proglabor.aufgabe3.gui;

import de.proglabor.aufgabe3.SimCollections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Starts the Application
 * Created by Tobias on 10.12.13.
 */


public class SimMain {

    public static void main(String[] args) throws IOException, InterruptedException{
        SimCollections model = new SimCollections();
        SimControlerInterface controler = new SimControler(model);      
        
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        while(true){
        	System.out.println("Anzahl der Tage die ausgeführt werden sollen?");
        	int days = scanner.read();
        	try {
        			controler.run(days);
        	}catch(NumberFormatException nfe){
        		System.err.println("Invalid Format!");
        	}        
		}
    }
}
