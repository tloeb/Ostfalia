
package de.proglabor.aufgabe3;

public class Pflanze implements PflanzeInterface, Comparable<Pflanze> {
	private static final int PLANTENERGY = 20;

	private int x;
	private int y;
	private int energy;

	public Pflanze(int xx, int yy) {
		this.x = xx;
		this.y = yy;
		this.energy = PLANTENERGY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getEnergy() {
		return energy;
	}

	@Override
	/**
	 * erm�glicht das Vergleichen zweier Pflanzenobjekte
	 */
	public int compareTo(Pflanze comparator) {
		if (this.x == comparator.getX() && this.y == comparator.getY()) {
			return 0;
		} else if (this.x * this.y < comparator.getX() * comparator.getY()) {
			return 1;
		}
		return -1;
	}
}
