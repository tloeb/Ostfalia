package uebungsaufgabe.algo;

public class Polynomwert {
	
	public static float Pwert(float [] a, float x) {
		
		float pol = a[0];
		System.out.print(pol);
		for (int i = 1; i < a.length; i++) {
			pol = (float) (pol + a[i] * Math.pow(x, i));
			System.out.print(" + " + a[i] + " *x^" + i);
		}		
		return pol;
		
	}

	public static void main(String[] args) {
		float [] testarray = {5.2f,2.3f,4.5f};
		System.out.println("\n Polynomwert: " + Pwert(testarray, 2f));
	}

}
