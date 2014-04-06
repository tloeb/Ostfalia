package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;
import java.util.*;


public class Produktverwalter implements ProductManager {
public static int IDcount = 1;
	private Hashtable<Integer, Product> ProductLib = new Hashtable<Integer, Product>();
	/**
	 *  Liefert eine neue Product-Instanz mit Beschreibung und Preis zurueck.
	 *  Product-Ids sind Integer groesser 0.
	 */
	public Product newProduct(String description, BigDecimal price){
		Product newPro = new Produkt(description, price, IDcount);
		ProductLib.put(newPro.getId(), newPro);
		IDcount++;
		return newPro;		
	}
	/**
	 * Liefert die Product-Instanz mit Id id zurueck.
	 * @param id Id der Product-Instanz
	 * @return Product-Instanz mit Id id
	 * @throws NoSuchProductException, falls Product nicht existiert
	 */
	public Product find(Integer id) throws NoSuchProductException{
		Product selProduct = ProductLib.get(id);
		if (selProduct == null)
			throw new NoSuchProductException();
		
		return selProduct;	
	}
	/**
	 *  Loescht Product-Instanz mit Id id.
	 */
	public void delete(Integer id){
		ProductLib.remove(id);
	}
}
