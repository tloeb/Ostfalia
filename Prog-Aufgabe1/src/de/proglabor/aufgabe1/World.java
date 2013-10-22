package de.proglabor.aufgabe1;


public class World {

	private int width = 40; // Default 40
	private int height = 30; // Default 30

	private int widthJungle = 10; // Default 10
	private int heightJungle = 10; // Default 10

	private int [][] desert;
	private int [][] jungle;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidthJungle() {
		return widthJungle;
	}

	public void setWidthJungle(int widthJungle) {
		this.widthJungle = widthJungle;
	}

	public int getHeightJungle() {
		return heightJungle;
	}

	public void setHeightJungle(int heightJungle) {
		this.heightJungle = heightJungle;
	}

	public int[][] getDesert() {
		return desert;
	}

	public void setDesert(int[][] desert) {
		this.desert = desert;
	}

	public int[][] getJungle() {
		return jungle;
	}

	public void setJungle(int[][] jungle) {
		this.jungle = jungle;
	}

	//Konstruktor 
	public World(int w, int h, int wJ, int hJ) {
		this.width = w;
		this.height = h;
		this.heightJungle = hJ;
		this.widthJungle = wJ;
		
		if (w > wJ && h > hJ) {
			desert = new int[width][height];
			jungle = new int[widthJungle][heightJungle];
			
			updateField();	
		}	
		else
			System.out.println("Der Jungle darf nicht größer sein als die Wüste");
	}
	
	public void updateField() {
		
		// Jungle mittig der Wüste platzieren
		
		// Field x -> y
		for (int x = (width/2)-widthJungle/2; x < width; x++) {
			for (int y = (height/2) - heightJungle/2; y < height; y++) {
				
				//Desert xj -> yj
				for (int xj = 0; xj < widthJungle; xj++) {
					for(int yj = 0; yj < heightJungle; yj++) {
						//Zuweisung von xj auf x
						desert [x][y] = jungle[xj][yj];
					}
						
				}
				
				
			}
		}
	}
	
	//Platzieren einer Dummy Pflanze
	public void placePlant(int x, int y) {
		
	}
	
	
	
	
}
