package com.example.stockMgtService.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Item")

//Creating the Item class
public class Item {

	//Attiributes
	
	@GeneratedValue @Id
	private int id;
	
	@Column(name="item_name")
	private String itemName;
	
	//@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name="EXD")
	private Date EXD ;
	
	@Column(name="MFD")
	private Date MFD ;
	
	
	@Column(name="quantity")
	private Long quantity ;

	@Column(name="unitPrice")
	private Long unitPrice ;
	
	@Column(name="supplierName")
	private String supplierName ;
	
	
	@Column(name="ordedQuantity")
	private Long ordedQuantity ;
	
	
	//Getters and Setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getEXD() {
		return EXD;
	}

	public void setEXD(Date eXD) {
		EXD = eXD;
	}

	public Date getMFD() {
		return MFD;
	}

	public void setMFD(Date mFD) {
		MFD = mFD;
	}
	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Long getOrdedQuantity() {
		return ordedQuantity;
	}

	public void setOrdedQuantity(Long ordedQuantity) {
		this.ordedQuantity = ordedQuantity;
	}

	
}
