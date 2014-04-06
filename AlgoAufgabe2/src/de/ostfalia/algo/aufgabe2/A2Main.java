package de.ostfalia.algo.aufgabe2;

import java.util.Scanner;

public class A2Main {
    public static void main(String[] args) {
	Aufgabe2 a2 = new Aufgabe2();
	Scanner input = new Scanner(System.in);
	boolean quit = false;
	int choose, n, k;
	String menu = createStartmenu();
	while (!quit) {
	    System.out.println(menu);
	    System.out.println("Bitte Eintrag auswählen:");
	    choose = input.nextInt();
	    switch (choose) {
	    case 1:
		System.out.println("n eingeben:");
		n = input.nextInt();
		System.out.println("k eingeben:");
		k = input.nextInt();
		System.out.println("Ergebnis: " + a2.binomialkoeffizient_Fakultaet(n, k));
		System.out.println("Zähler: " + a2.getZaehler());
		break;
	    case 2:
		System.out.println("n eingeben:");
		n = input.nextInt();
		System.out.println("k eingeben:");
		k = input.nextInt();
		System.out.println("Ergebnis: " + a2.binomialkoeffizient_Iterativ(n, k));
		System.out.println("Zähler: " + a2.getZaehler());
		break;
	    case 3:
		System.out.println("n eingeben:");
		n = input.nextInt();
		System.out.println("k eingeben:");
		k = input.nextInt();
		System.out.println("Ergebnis: " + a2.binomialkoeffizient_Rekursiv(n, k));
		System.out.println("Zähler: " + a2.getZaehler());
		break;
	    case 4:
		System.out.println("n eingeben:");
		n = input.nextInt();
		System.out.println("k eingeben:");
		k = input.nextInt();
		System.out.println("Ergebnis: " + a2.binomialkoeffizient_Iterativ2(n, k));
		System.out.println("Zähler: " + a2.getZaehler());
		break;
	    case 5:
		quit = true;
		break;
	    default:
		System.out.println("Ungültige Eingabe\n");
		break;
	    }
	    clearScreen();
	}
	input.close();
    }
    
    private static String createStartmenu() {
	StringBuilder sb = new StringBuilder();
	sb.append("### Binomialkoeffizientenberechnung ###");
	sb.append("\n\n");
	sb.append("1:\tBerechnung über Fakultät\n");
	sb.append("2:\tIterative Berechnung\n");
	sb.append("3:\tRekursive Berechnung\n");
	sb.append("4:\tIterative Berechnung (Variation)\n");
	sb.append("\n\n");
	sb.append("5:\tProgramm verlassen\n");
	return sb.toString();
    }
    
    private static void clearScreen() {
	for (int i = 0; i < 3; i++) {
	    System.out.println("\n");
	}
    }
}
