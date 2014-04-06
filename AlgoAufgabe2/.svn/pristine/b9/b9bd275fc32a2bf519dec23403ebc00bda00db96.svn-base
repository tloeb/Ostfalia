package de.ostfalia.algo.aufgabe2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.ostfalia.algo.aufgabe2.Aufgabe2;

public class Aufgabe2TestPublic {
	
	private int[] exp = // n über n/2
		{1, 1, 2, 3, 6, 10, 20, 35, 70, 126,
		 252, 462, 924, 1716, 3432, 6435, 12870,
		 24310, 48620, 92378, 184756, 352716, 705432, 
		 1352078, 2704156, 5200300, 10400600, 20058300,
		 40116600, 77558760}; //30
	
	private int[] rec = {
			1, 1, 3, 5, 11, 19, 39, 69, 139, 251, 503,
			923, 1847, 3431, 6863, 12869, 25739, 48619,
			97239, 184755, 369511, 705431, 1410863,
			2704155, 5408311};

	
	@Test (timeout = 500)
	public void testFakultaet() {
		Aufgabe2 a2 = new Aufgabe2();	
		assertEquals("0! -->",   1, a2.fakultaet(0));
		assertEquals("1! -->",   1, a2.fakultaet(1));
		assertEquals("2! -->",   2, a2.fakultaet(2));
		assertEquals("3! -->",   6, a2.fakultaet(3));
		assertEquals("4! -->",  24, a2.fakultaet(4));
		assertEquals("5! -->", 120, a2.fakultaet(5));
	}

	@Test (timeout = 1000)
	public void testBinomialkoeffizient_Fakultaet() {
		Aufgabe2 a2 = new Aufgabe2();	
		int bk;
		for (int n = 0; n <= 12; n++) {
			bk = a2.binomialkoeffizient_Fakultaet(n, n);			
			assertTrue(format(n, n, 1, bk), bk == 1);
			assertEquals("Zähler: ", n, a2.getZaehler());
			bk = a2.binomialkoeffizient_Fakultaet(n, 0);
			assertEquals("Zähler: ", n, a2.getZaehler());
			assertTrue(format(n, 0, 1, bk), bk == 1);
		}		
		for (int n = 0; n <= 12; n++) {
			bk = a2.binomialkoeffizient_Fakultaet(n, n / 2);
			assertTrue(format(n, n / 2, exp[n], bk), bk == exp[n]);
			assertEquals("Zähler: ", n, a2.getZaehler());			
		}			
	}
	
	@Test (timeout = 1000)
	public void testBinomialkoeffizient_Iterativ() {
		Aufgabe2 a2 = new Aufgabe2();	
		int bk;
		for (int n = 0; n <= 12; n++) {
			bk = a2.binomialkoeffizient_Iterativ(n, n);			
			assertTrue(format(n, n, 1, bk), bk == 1);
			assertEquals("Zähler: ", n, a2.getZaehler());						
			bk = a2.binomialkoeffizient_Iterativ(n, 0);
			assertEquals("Zähler: ", 0, a2.getZaehler());
			assertTrue(format(n, 0, 1, bk), bk == 1);
		}		
		for (int n = 0; n <= 12; n++) {
			bk = a2.binomialkoeffizient_Iterativ(n, n / 2);						
			assertTrue(format(n, n / 2, exp[n], bk), bk == exp[n]);
			assertEquals("Zähler: ", n / 2, a2.getZaehler());
		}	
	}
	
	@Test (timeout = 1000)
	public void testBinomialkoeffizient_Rekursiv() {
		Aufgabe2 a2 = new Aufgabe2();			
		int bk;
		for (int n = 0; n <= 24; n++) {
			bk = a2.binomialkoeffizient_Rekursiv(n, n);
			assertTrue(format(n, n, 1, bk), bk == 1);
			assertEquals("Zähler: ", 1, a2.getZaehler());
			bk = a2.binomialkoeffizient_Rekursiv(n, 0);			
			assertTrue(format(n, 0, 1, bk), bk == 1);
			assertEquals("Zähler: ", 1, a2.getZaehler());
		}							
		for (int n = 0; n <= 24; n++) { //bis 30
			bk = a2.binomialkoeffizient_Rekursiv(n, n / 2);			
			assertTrue(format(n, n / 2, exp[n], bk), bk == exp[n]);
			assertEquals("Zähler: ", rec[n], a2.getZaehler());
		}		
	}
	
	
	@Test (timeout = 1000)
	public void testBinomialkoeffizient_Iterativ2() {
		Aufgabe2 a2 = new Aufgabe2();	
		int bk;
		for (int n = 0; n < exp.length; n++) {
			bk = a2.binomialkoeffizient_Iterativ2(n, n);
			assertTrue(format(n, n, 1, bk), bk == 1);
			assertEquals("Zähler: ", n, a2.getZaehler());
			bk = a2.binomialkoeffizient_Iterativ2(n, 0);			
			assertTrue(format(n, 0, 1, bk), bk == 1);
			assertEquals("Zähler: ", 0, a2.getZaehler());
		}		
		for (int n = 0; n < exp.length; n++) {
			bk = a2.binomialkoeffizient_Iterativ2(n, n / 2);			
			assertTrue(format(n, n / 2, exp[n], bk), bk == exp[n]);
			assertEquals("Zähler: ", n / 2, a2.getZaehler());
		}					
	}
	
	private String format(int n, int k, int expected, int actual) {
		return String.format("%d über %d: erwartet %d erhalten %d",
				             n, k, expected, actual);		
	}	

}
