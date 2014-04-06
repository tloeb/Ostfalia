package de.proglabor.aufgabe3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.Observable;

/**
 * Enthält das Model der Simulation.
 * @author Tobias
 *
 */

public class SimCollections extends Observable implements
		SimCollectionsInterface {
	// bit-masks
	private static final int TYPE_STEPPE = 0x00;
	private static final int TYPE_JUNGLE = 0x01;
	
	private static final int STANDARTH = 40;
	private static final int STANDARTW = 30;
	private static final int STANDARTHJ = 10;
	private static final int STANDARTWJ = 10;

	private static int height = STANDARTH;
	private static int width = STANDARTW;
	private static int heightJungle = STANDARTHJ;
	private static int widthJungle = STANDARTWJ;

	// end coordinates, from 0 to size-1
	private static int jungleXStart = width / 2 - widthJungle / 2 - 1;
	// private static int JUNGLEXEND = Math.min((JUNGLEXSTART + WIDTHJUNGLE /
	// 2), WIDTH - 1);

	private static int jungleYStart = height / 2 - heightJungle / 2 - 1;
	// private static int JUNGLEYEND = Math.min((JUNGLEYSTART + HEIGHTJUNGLE /
	// 2), HEIGHT - 1);

	private static final int INITIALENERGY = 1000;
	/*
	 * Energy welche die Tiere zum Vermehren benötigen
	 */
	private static final int REPRODUCTIONENERGY = 200;

	private int[][] feld;
	private LinkedList<TierInterface> tiere = new LinkedList<TierInterface>();
	private List<Pflanze> pflanzen = new ArrayList<Pflanze>();

	/**
	 * Konstruktor des Models.
	 * @param w Breite
	 * @param h Höhe
	 * @param jw Jungle Breite
	 * @param jh Jungle Höhe
	 */
	public SimCollections(int w, int h, int jw, int jh) {
		buildWorld(w, h, jw, jh);
		Tier erstes = new Tier();
		erstes.randomGenes();
		erstes.setPosition(this.height / 2, this.width / 2);
		erstes.eat(INITIALENERGY);
		tiere.add(erstes);
	}

	/**.
	 * ruft den Konstruktor mit den Standartwerten auf.
	 */
	public SimCollections() {
		this(width, height, widthJungle, heightJungle);
	}

	/**.
	 * lässt Pflanzen spawnen
	 * eine im Jungle und eine auf der Welt
	 */
	public void spawnPlants() {
		// now spawn new plants in jungle
		int plantSpawnX;
		int plantSpawnY;
		Random randPlantSpawn = new Random();
		do {
			plantSpawnX = randPlantSpawn.nextInt(width);
			plantSpawnY = randPlantSpawn.nextInt(height);
		} while (feld[plantSpawnX][plantSpawnY] != TYPE_JUNGLE);
		pflanzen.add(new Pflanze(plantSpawnX, plantSpawnY));

		// now somewhere in steppe
		plantSpawnX = randPlantSpawn.nextInt(width);
		plantSpawnY = randPlantSpawn.nextInt(height);
		pflanzen.add(new Pflanze(plantSpawnX, plantSpawnY));

	}

	/**
	 * führt day() mit Zufallswerten aus.
	 */
	public void day() {
		Random rand = new Random();
		day(rand.nextInt(), rand.nextInt(), rand.nextInt());
	}

	/*
	 * (non-Javadoc)
	 * @see de.proglabor.aufgabe3.SimCollectionsInterface#day(int, int, int)
	 */
	public void day(int randomDirection, int randomReproduceGene,
			int randomReproduceMutation) {
		List<TierInterface> toteTiere = new LinkedList<TierInterface>();
		// wird hier geholt, damit neue tiere erst am nï¿½chsten tag was machen
		int anzahlTiere = tiere.size();
		for (int i = 0; i < anzahlTiere; i++) {
			TierInterface aktuellesTier = tiere.get(i);
			// turn
			aktuellesTier.turn(randomDirection);
			// move
			aktuellesTier.move(height, width);

			// eat
			for (int c = 0; c < pflanzen.size(); c++) {
				Pflanze aktuellePflanze = pflanzen.get(c);
				if (aktuellePflanze.getX() == aktuellesTier.getX()
						&& aktuellePflanze.getY() == aktuellesTier.getY()) {
					aktuellesTier.eat(aktuellePflanze.getEnergy());
					pflanzen.remove(aktuellePflanze);
					break;
				}
			}
			aktuellesTier.eat(-1);

			// if this animal is dead we add it to the list of dead animals, we
			// can't remove right here because of tiere.size()
			if (aktuellesTier.getEnergy() <= 0) {
				toteTiere.add(aktuellesTier);
			}

			// reproduce
			if (aktuellesTier.getEnergy() >= REPRODUCTIONENERGY) {
				TierInterface nachwuchs = aktuellesTier.reproduce(
						randomReproduceGene, randomReproduceMutation);
				tiere.add(nachwuchs);
			}

		}

		// now remove them
		for (int i = 0; i < toteTiere.size(); i++) {
			tiere.remove(toteTiere.get(i));
		}

		spawnPlants();
		setChanged();
		notifyObservers();
	}
	/*
	 * (non-Javadoc)
	 * @see de.proglabor.aufgabe3.SimCollectionsInterface#getAnzahlTiere(int, int)
	 */
	public int getAnzahlTiere(int x, int y) {
		int anzahl = 0;
		for (int i = 0; i < tiere.size(); i++) {
			TierInterface aktuellesTier = tiere.get(i);
			if (aktuellesTier.getX() == x && aktuellesTier.getY() == y) {
				anzahl++;
			}
		}
		return anzahl;
	}
	/*
	 * (non-Javadoc)
	 * @see de.proglabor.aufgabe3.SimCollectionsInterface#getAnzahlTiereAll()
	 */
	public int getAnzahlTiereAll() {
		return tiere.size();
	}
	/*
	 * (non-Javadoc)
	 * @see de.proglabor.aufgabe3.SimCollectionsInterface#getAnzahlPflanzen(int, int)
	 */
	public int getAnzahlPflanzen(int x, int y) {
		int anzahl = 0;
		for (int c = 0; c < pflanzen.size(); c++) {
			PflanzeInterface aktuellePflanze = pflanzen.get(c);
			if (aktuellePflanze.getX() == x && aktuellePflanze.getY() == y) {
				anzahl++;
			}
		}
		return anzahl;
	}
	/*
	 * (non-Javadoc)
	 * @see de.proglabor.aufgabe3.SimCollectionsInterface#getAnzahlPflanzenAll()
	 */
	public int getAnzahlPflanzenAll() {
		return pflanzen.size();
	}

	public LinkedList<TierInterface> getTiere() {
		// Arraylist--> LinkedList
		// LinkedList<Tier> newTier = new LinkedList<Tier>();
		// int anzahlTiere = tiere.size();
		// for (int i = 0; i < anzahlTiere; i++)
		// {
		// Tier aktuellesTier = tiere.get(i);
		// newTier.add(aktuellesTier);
		// }

		return this.tiere;
	}
	/*
	 * (non-Javadoc)
	 * @see de.proglabor.aufgabe3.SimCollectionsInterface#getPflanzen()
	 */
	public TreeMap<Pflanze, Integer> getPflanzen() {
		TreeMap<Pflanze, Integer> newPflanze = new TreeMap<Pflanze, Integer>();
		for (int x = 0; x <= feld.length; x++) {
			for (int y = 0; y <= feld[0].length; y++) {

				if (getAnzahlPflanzen(x, y) > 0) {
					Pflanze pflanzencontainer = new Pflanze(x, y);
					newPflanze.put(pflanzencontainer, getAnzahlPflanzen(x, y));
				}

			}
		}
		return newPflanze;
	}
	/*
	 * (non-Javadoc)
	 * @see de.proglabor.aufgabe3.SimCollectionsInterface#setTier(de.proglabor.aufgabe3.Tier)
	 */
	public void setTier(Tier neuesTier) {
		tiere.add(neuesTier);
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String ret = "";
		for (int i = 0; i < tiere.size(); i++) {
			TierInterface aktuellesTier = tiere.get(i);
			ret += aktuellesTier.toString();
			ret += "\n";
		}
		return ret;
	}

	/**
	 * Getter and Setter Section.
	 * 
	 * @return worldHeight, worldWidth, jungleWidth, jungleHeight
	 */

	public int getHEIGHT() {
		return this.height;
	}

	public int getWIDTH() {
		return this.width;
	}

	public int getHeightjungle() {
		return this.heightJungle;
	}

	public int getWidthjungle() {
		return this.widthJungle;
	}

	public boolean getFeldTyp(int x, int y) {
		if (feld[x][y] == TYPE_JUNGLE) {
			return true;
		} else{
			return false;
		}
	}

	public void setWIDTH(int i) {
		this.width = i;
	}

	public void setHEIGHT(int i) {
		this.height = i;
	}

	public void setHeightjungle(int i) {
		if (i <= this.height) {
			this.heightJungle = i;
		}
	}

	public void setWidthjungle(int i) {
		if (i <= this.width){
			this.widthJungle = i;
		}
	}

	public void buildWorld(int w, int h, int jw, int jh) {
		feld = null;

		this.setWIDTH(w);
		this.setHEIGHT(h);
		this.setHeightjungle(jh);
		this.setWidthjungle(jw);

		int screenCenterX = w / 2;
		int jxstart = screenCenterX - (jw / 2);
		// int jxend = Math.min((JUNGLEXSTART + WIDTHJUNGLE / 2), WIDTH - 1);

		int screenCenterY = h / 2;
		int jystart = screenCenterY - jh / 2;
		// int jyend = Math.min((JUNGLEYSTART + HEIGHTJUNGLE / 2), HEIGHT - 1);

		// creates the steppe and fills jungle in centre
		feld = new int[w][h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				// including feld[JUNGLESTART] and feld[JUNGLEEND]
				if (x >= jxstart && x <= jxstart + jw - 1 && y >= jystart
						&& y <= jystart + jh - 1) {
					feld[x][y] = TYPE_JUNGLE;
				} else {
					feld[x][y] = TYPE_STEPPE;
				}
			}
		}

	}

}
