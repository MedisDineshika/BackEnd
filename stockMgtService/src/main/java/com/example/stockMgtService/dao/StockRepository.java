package com.example.stockMgtService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockMgtService.model.Product;

public interface StockRepository extends  JpaRepository<Product,Long>{

	

	
}
