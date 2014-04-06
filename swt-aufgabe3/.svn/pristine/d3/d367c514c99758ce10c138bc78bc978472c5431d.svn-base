package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;

public class MainMethod {

	public static void main(String[] args) throws NoSuchProductException {

		ProductManager man = new Produktverwalter();
		Product firstprodukt = man.newProduct("Hello World",new BigDecimal("5.00"));
		Product secprodukt = man.newProduct("Hello World2",new BigDecimal("4.00"));
		System.out.println(firstprodukt.getId());
		System.out.println(secprodukt.getId());
		
		Product searchProdukt = man.find(2);
		System.out.println(searchProdukt.getDescription());
		System.out.println(searchProdukt.getPrice());
		
		man.delete(2);
		Product searchdeletedProdukt = man.find(2);
		System.out.println(searchdeletedProdukt.getDescription());
		System.out.println(searchdeletedProdukt.getPrice());
	}

}
