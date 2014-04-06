package de.ostfalia.swt.aufgabe1;

public class Main {

	public static void main(String[] args) {
		Analyzer anal = new Analyzer();
		Object obj = new Object();
		
		System.out.println(anal.getAllPublicMethods(obj.getClass().getName().toString()));
		System.out.println(anal.getInterfaces(obj).toString());
		System.out.println(anal.isToStringOverwritten(obj.getClass()));
		

	}

}
