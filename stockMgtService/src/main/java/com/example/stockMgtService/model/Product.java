package com.example.stockMgtService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	
	private String product_name;
	
	
	private String description ;
	
	private long quantity;
	
	
	private long price;
	private String colour ;
	
	
	private String size;
	
	private String brand;
	
	private String category ;
	
	private long reorderLevel;

	
	

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(long reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	
	
	
	
	
	
	
}
