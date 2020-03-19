package com.example.stockMgtService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockMgtService.model.Product;
import com.example.stockMgtService.service.StockService;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class StockMgtContoller {

	
	@Autowired 
	StockService stockService;
	
	@PostMapping("/stock")
	public Product saveProduct(@RequestBody Product product) {
	        return stockService.save(product);
	    }
	
}
