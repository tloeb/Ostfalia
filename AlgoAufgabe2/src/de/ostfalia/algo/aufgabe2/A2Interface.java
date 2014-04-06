package de.ostfalia.algo.aufgabe2;

public interface A2Interface {

	/**
	 * Berechnet die Binomialkoeffizienten (n �ber k) 
	 * mit Hilfe der Fakult�t.
	 * @param n - Wert f�r n (n >= 0): int. 
	 * @param k - Wert f�r k (0 <= k <= n): int.
	 * @return n �ber k: int.
	 */
	public abstract int binomialkoeffizient_Fakultaet(int n, int k);
	
	/**
	 * Liefert die Fatult�t der Zahl n.
	 * @param n	- granze Zahl >= 0: int. 
	 * @return Fatult�t der Zahl n: int.
	 */
	public abstract int fakultaet(int n);

	/**
	 * Berechnet die Binomialkoeffizienten (n �ber k) 
	 * iterativ.
	 * @param n - Wert f�r n (n >= 0): int. 
	 * @param k - Wert f�r k (0 <= k <= n): int.
	 * @return n �ber k: int.
	 */
	public abstract int binomialkoeffizient_Iterativ(int n, int k);

	/**
	 * Berechnet die Binomialkoeffizienten (n �ber k) 
	 * rekursiv.
	 * @param n - Wert f�r n (n >= 0): int. 
	 * @param k - Wert f�r k (0 <= k <= n): int.
	 * @return n �ber k: int.
	 */
	public abstract int binomialkoeffizient_Rekursiv(int n, int k);

	/**
	 * Berechnet die Binomialkoeffizienten (n �ber k) 
	 * iterativ (Variante).
	 * @param n - Wert f�r n (n >= 0): int. 
	 * @param k - Wert f�r k (0 <= k <= n): int.
	 * @return n �ber k: int.
	 */
	public abstract int binomialkoeffizient_Iterativ2(int n, int k);

	/**
	 * Liefert den Schleifenz�hler bzw. Rekursionsz�hler
	 * zur�ck.
	 * @return Schleifenz�hler bzw. Rekursionsz�hler: int.
	 */	
	public int getZaehler();

}