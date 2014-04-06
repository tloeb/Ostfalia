package de.ostfalia.swt.aufgabe2;

public class Fakultaet2 {
	
	public long factorial(long n){
		if(n==1)
			return 1;
		else
			return factorial(n-1)*n;
			}
}
