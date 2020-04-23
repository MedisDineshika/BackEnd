package com.example.stockMgtService.service;

import java.util.List;
import java.util.Optional;

import com.example.stockMgtService.model.Product;

public interface StockService  {
	
	Product  save(Product product);

	List<Product> findAll();

	public Optional<Product> findByID(Long id);
	
	

}
