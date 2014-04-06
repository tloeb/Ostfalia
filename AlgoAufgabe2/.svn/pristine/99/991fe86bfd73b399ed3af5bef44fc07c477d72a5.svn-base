package de.ostfalia.algo.fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	
	final String dateiname = "Materialien/Ausgabe/testdaten.txt";
			
	/**
	 * Beispielprogramm für das Schreiben einer Zahl in
	 * eine Textdatei.
	 * @param dateiname - Name der Textdatei: String.
	 * @throws IOException
	 */
	public void schreibeDaten(String dateiname, int zahl) throws IOException {		
		File file = new File(dateiname);
		FileWriter fw = new FileWriter(file);
		
		fw.write(zahl + System.lineSeparator());
		
		fw.close();	
	}
	
	/**
	 * Liest eine Zahl aus der angegebenen Datei.
	 * @param dateiname - Name der Datei: String.
	 * @return eingelesene Zahl, sonst 0: int.
	 * @throws IOException
	 */
	public int leseDaten(String dateiname) 
			throws IOException {		
		File file = new File(dateiname);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);	
		int zahl = 0;
		String line;
		if ((line = br.readLine()) != null) {
			zahl = Integer.parseInt(line);
		}
		br.close();
		fr.close();
		return zahl;
	}
	
	/**
	 * Ermittel die Anzahl der Zeilen in der angegebenen
	 * Textdatei.
	 * @param dateiname - Name der Datei: String.
	 * @return Anzahl der Zeilen in der Datei: int.
	 * @throws IOException
	 */
	public int anzahlZeilen(String dateiname) 
			throws IOException {		
		File file = new File(dateiname);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);	
		int zeilen = 0;		
		while (br.readLine() != null) {
			zeilen++;
		}
		br.close();
		fr.close();
		return zeilen;
	}
	
	public static void main(String[] args) throws IOException {
		FileIO io = new FileIO();
		io.schreibeDaten(io.dateiname, 55);
		System.out.println("Anzahl Zahlen: " 
				+ io.anzahlZeilen(io.dateiname));
		System.out.println("Eingelesene Zahl: " 
				+ io.leseDaten(io.dateiname));
	}
	
}
