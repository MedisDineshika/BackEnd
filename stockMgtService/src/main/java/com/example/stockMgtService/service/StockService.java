package com.example.stockMgtService.service;

import java.util.List;

import com.example.stockMgtService.model.Product;

public interface StockService  {
	
	Product  save(Product product);

	List<Product> findAll();
	

}
