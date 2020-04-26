package com.example.RegService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegService.dao.RegDao;
import com.example.RegService.model.Customer;

@Service
public class RegServiceImpl implements RegService {

	
	@Autowired 
	RegDao regDao ;
	
	
	@Override
	public Customer save(Customer customer) {
		return regDao.save(customer);
	}

}
