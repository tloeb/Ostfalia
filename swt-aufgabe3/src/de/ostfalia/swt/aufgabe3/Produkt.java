package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;

public class Produkt implements Product{
	
	private int ID;
	private String Description;
	private BigDecimal Price;
		
	public Produkt(String description, BigDecimal price, int id){
		this.Description = description;
		this.Price = price;
		this.ID = id;		
	}
	
	/**
	 * 
	 * @return ID of the Product
	 */
	public Integer getId(){
		return ID;
	}	

	/**
	 * 
	 * @return Description as String
	 */
	public String getDescription(){
		return Description;
	}
	
	/**
	 * 
	 * @param description The new Description Text
	 */
	public void setDescription(String description){
		this.Description = description;
	}

	/**
	 * 
	 * @return Price in BigDecimal of the Produkt
	 */
	public BigDecimal getPrice(){
		return Price;		
	}

	/**
	 * @param price The new Price for the Product
	 */
	public void setPrice(BigDecimal price){
		this.Price = price;
	}
}
