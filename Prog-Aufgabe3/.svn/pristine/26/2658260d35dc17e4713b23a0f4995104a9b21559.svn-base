package de.proglabor.aufgabe3.gui;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import de.proglabor.aufgabe3.SimCollections;

/**
 * Controler Created by Tobias on 10.12.13.
 */

public class SimControler implements SimControlerInterface {

	public static final int TAUSEND = 1000;
	private int counter = 0;
	private int day = 1;
	private SimCollections model;
	private SimView view;
	private boolean running = false;

	/**.
	 * Konstruktor des Controlers mit Übergabe des Models
	 * @param modell
	 */
	
	public SimControler(SimCollections modell) {
		this.model = modell;
		view = new SimView(modell, this);
		view.init(this.model);
	}

	/**.
	 * Führt die Simulation des Models daysToDo mal aus
	 * und liefert eine Konsolenausgabe
	 * @param daysToDo
	 */
	public void run(int daysToDo) throws IOException, InterruptedException {
		if (running) {
			for (int i = daysToDo; i > 0; i--) {
				// Runtime.getRuntime().exec("cls");
				model.day();
				System.out.println("Day: " + day);
				System.out.println(model.toString());

				System.out.println("-------------- Plantmap: --------------");
				for (int x = 0; x < model.getHEIGHT(); x++) {
					System.out.println(" ");
					for (int y = 0; y < model.getWIDTH(); y++) {
						System.out.print(model.getAnzahlPflanzen(x, y) + " ");
					}
				}
				System.out.println("\n ------------------------------");
				day++;
				counter++;
				// Thread.sleep(TAUSEND);
			}
		} else {
			System.out.println("Not Running!!");
		}
	}

	/**.
	 * Manipulieren der Überprüfung ob die Simulation läuft
	 */
	public void setRUNNING(boolean b) {
		this.running = b;
	}

	public boolean getRunning() {
		return this.running;
	}

	/**.
	 * ruft die BuildWorld Methode im Model auf welche die passenden Arrays erzeugt
	 */
	public void buildWorld(int w, int h, int jungleW, int jungleH) {
		model.buildWorld(w, h, jungleW, jungleH);
	}

}
