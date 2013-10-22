package de.proglabor.aufgabe1;

public class Plant {
	
	private int plantEnergy;
	private int initialEnergy;
	private int reproductionEnergy;
	
	private static int posX;
	private static int posY;
	
	public Plant (int hp, World welt) {
		this.initialEnergy = hp;
		
		// Zufällige Position erzeugen
		posX = randomNumber(welt.getJungle().length, welt.getJungle()[0].length);
		posY = randomNumber(welt.getJungle(), welt.getJungle()[0].length);
		
	}

	public int randomNumber (int min, int max) {
		double i = Math.random()* (max - min) + min;
		return  (int) i;
	}
	
	// Kann auch bei Tier implementiert werden
	public void getEaten() {
		
	}
}
