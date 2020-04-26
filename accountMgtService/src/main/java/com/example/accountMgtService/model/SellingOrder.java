package com.example.accountMgtService.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SellingOrder {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	
	
	private long pId;
	
	
	private String product_name;
	
	private String customer_name;
	
	
	
	private long quantity;
	
	
	private long price;
	
	 
	
	private long total;



	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getCustomer_name() {
		return customer_name;
	}



	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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



	public long getTotal() {
		return total;
	}



	public void setTotal(long total) {
		this.total = total;
	}



	public long getpId() {
		return pId;
	}



	public void setpId(long pId) {
		this.pId = pId;
	}



	


	
	
	
}
