package com.example.RegService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RegService.model.Customer;



public interface RegDao  extends  JpaRepository<Customer,Integer> {

}
