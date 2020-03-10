package com.example.stockMgtService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	
	public Product() {
		
	}

	public Product(Integer id, String product_name, long price, int qty, String description, String colour, String size,
			String brand, String category, String availabilty) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
		this.qty = qty;
		this.description = description;
		this.colour = colour;
		this.size = size;
		this.brand = brand;
		this.category = category;
		this.availabilty = availabilty;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	
	private String product_name;
	
	private long price ;
	
	private int qty;
	
	private String description ;
	
	private String colour ;
	
	
	private String size;
	
	private String brand;
	
	private String category ;
	
	private String availabilty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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

	public String getAvailabilty() {
		return availabilty;
	}

	public void setAvailabilty(String availabilty) {
		this.availabilty = availabilty;
	}
	
	
	
	
	
	
}
