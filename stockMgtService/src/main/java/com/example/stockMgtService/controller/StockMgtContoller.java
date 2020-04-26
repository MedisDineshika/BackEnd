package com.example.stockMgtService.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockMgtService.dao.StockRepository;
import com.example.stockMgtService.exception.ResourceNotFoundException;
import com.example.stockMgtService.model.Product;
import com.example.stockMgtService.service.StockService;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class StockMgtContoller {

	
	@Autowired 
	StockService stockService;
	
	@Autowired 
	StockRepository stockRepository;
	
	@PostMapping("/stock")
	public Product saveProduct(@RequestBody Product product) {
	        return stockService.save(product);
	    }
	
	
	@GetMapping("/stock")
    public List<Product> getAllProducts() {
        return stockService.findAll();
    }
	
	@GetMapping("/acc")
    public Optional<Product> getProduct(Long id) {
        return stockService.findByID(id);
        
    }
	
	@GetMapping("/stock/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException {
		Product product = stockRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        return ResponseEntity.ok().body(product);
    }
	
	
}
