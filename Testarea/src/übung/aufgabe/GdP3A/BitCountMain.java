package übung.aufgabe.GdP3A;

public class BitCountMain {

	public static void main(String[] args) {

		int zahl = 50;
		BitCount bc = new BitCount(zahl);

		String zahldual = bc.getDual();
		String zahldualrevert = bc.revert(zahldual);

		System.out.println("Zahl: " + zahl);
		System.out.println("Anzahl der Bits: " + bc.getBitanzahl());
		System.out.println("Eingabe Dual " + zahldual);
		System.out.println("Eingabe Dual reverted: " + zahldualrevert);

		System.out.println("Kontrolle: Dual --> Dez: " + bc.getDez(zahldual));
		System.out.println("Kontrolle: Dual reverted --> Dez: "
				+ bc.getDez(zahldualrevert));
	}

}
