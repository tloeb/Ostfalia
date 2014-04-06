package de.proglabor.aufgabe3;

import java.util.Random;

public class Tier implements TierInterface {
	private static final int DREI = 3;
	private static final int VIER = 4;
	private static final int FUENF = 5;
	private static final int SECHS = 6;
	private static final int SIEBEN = 7;
	private static final int ACHT = 8;
	
	private int dir;
	private int[] genes = new int[ACHT];
	private int energy;
	private int x;
	private int y;
	private int lifetime;

	private static final int ZEHN = 10;

	/*
	 * (non-Javadoc)
	 * @see de.proglabor.aufgabe3.TierInterface#mutate(int, int)
	 */
	public void mutate(int randomGene, int randomMutation) {
		switch (Math.abs(randomMutation) % DREI) {
		case 0:
			genes[Math.abs(randomGene) % genes.length] -= 1;
			if (genes[Math.abs(randomGene) % genes.length] < 1) {
				genes[Math.abs(randomGene) % genes.length] = 1;
			}
			break;
		case 1:
			break;
		case 2:
			genes[Math.abs(randomGene) % genes.length] += 1;
			break;
		default:
			break;
		}
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#randomGenes()
 */
	public void randomGenes() {
		Random rand = new Random();
		for (int i = 0; i < genes.length; i++) {
			genes[i] = rand.nextInt(ZEHN) + 1;
		}
	}
/*
 * 
 */
	public Tier() {
		// that way we can copy genes easily
		lifetime = 0;

		energy = 0;
		dir = 0;
	}
/*
 * 
 */
	public Tier(int xx, int yy, int energyy, int dirr, int[] geness) {
		this.x = xx;
		this.y = yy;
		this.dir = dirr;
		this.energy = energyy;
		this.genes = geness;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#getDir()
 */
	public int getDir() {
		return dir;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#getGenes()
 */
	public int[] getGenes() {
		return genes;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#setGenes(int[])
 */
	public void setGenes(int[] geness) {
		this.genes = geness.clone();
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#getEnergy()
 */
	public int getEnergy() {
		return energy;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#getLifetime()
 */
	public int getLifetime() {
		return lifetime;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#getX()
 */
	public int getX() {
		return x;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#getY()
 */
	public int getY() {
		return y;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#turn(int)
 */
	public void turn(int randomDirection) {
		lifetime++;
		int genSumme = 0;

		for (int i = 0; i < genes.length; i++) {
			genSumme += genes[i];
		}

		int choice = Math.abs(randomDirection) % genSumme;

		int c = 0;
		for (int i = 0; i < genes.length; i++) {
			c += genes[i];
			if (choice < c) {
				dir = i;
				break;
			}
		}
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#setPosition(int, int)
 */
	public void setPosition(int xx, int yy) {
		this.x = xx;
		this.y = yy;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#move(int, int)
 */
	public void move(int height, int width) {
		switch (dir) {
		case 0:
			y -= 1;
			x -= 1;
			break;
		case 1:
			y -= 1;
			break;
		case 2:
			y -= 1;
			x += 1;
			break;
		case DREI:
			x += 1;
			break;
		case VIER:
			y += 1;
			x += 1;
			break;
		case FUENF:
			y += 1;
			break;
		case SECHS:
			y += 1;
			x -= 1;
			break;
		case SIEBEN:
			x -= 1;
			break;
		default:
			break;
		}

		if (y >= height) {
			y = y % height;
		}
		if (y < 0) {
			y = height + y;
		}
		if (x >= width) {
			x = x % width;
		}
		if (x < 0) {
			x = width + x;
		}
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#eat(int)
 */
	public void eat(int plantEnergy) {
		energy += plantEnergy;
	}
/*
 * (non-Javadoc)
 * @see de.proglabor.aufgabe3.TierInterface#reproduce(int, int)
 */
	public TierInterface reproduce(int randomGene, int randomMutation) {
		Tier nachwuchs = new Tier();
		nachwuchs.eat(energy / 2);
		energy -= (energy / 2);
		nachwuchs.setPosition(x, y);
		nachwuchs.setGenes(genes);
		nachwuchs.mutate(randomGene, randomMutation);
		return nachwuchs;
	}
/*
 * 
 */
	public TierInterface reproduce() {
		Random rand = new Random();
		return reproduce(rand.nextInt(), rand.nextInt());
	}
/*
 * (non-Javadoc)
 * @see java.lang.Object#toString()
 */
	public String toString() {
		return "[" + x + "|" + y + "][" + energy + "][" + lifetime + "]";
	}
}
