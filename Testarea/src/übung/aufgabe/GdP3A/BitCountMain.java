package übung.aufgabe.GdP3A;

import java.util.Arrays;

public class BitCountMain {

	public static void main(String[] args) {

		BitCount bc = new BitCount(10);
		
		int [] i = bc.getBits();

		System.out.println("Anzahl der Bits: " + bc.getBitanzahl());
		System.out.println(bc.toString(bc.getBits()));
	}

}
