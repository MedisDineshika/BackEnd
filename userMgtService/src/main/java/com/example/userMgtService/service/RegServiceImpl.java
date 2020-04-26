package com.example.userMgtService.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.userMgtService.dao.UserRepository;
import com.example.userMgtService.model.Reg;

//import com.fasterxml.jackson.databind.util.JSONPObject;


@Service
@Transactional

public class RegServiceImpl implements RegService {

	
	@Autowired
	UserRepository userRepository;
	
	
	//Checking login details 
	@Override
	public Reg checkLogin(String userName, String password) {
		
		return userRepository.checkLogin(userName, password);
		
	}

	@Override
	public void save(Reg reg) {
		//reg.setPassword(bCryptPasswordEncoder.encode(reg.getPassword()));
		userRepository.save(reg);
		
	}

	@Override
	public Optional<Reg> findByID(long id) {
		return userRepository.findById(id)	;
	}

	
	@Override
	public Reg checkUser(String userName) {
		return userRepository.checkUser(userName);
	}

	//@Override
	//public void save(RoleType roleType) {
	//	userRepository.save(roleType);
		
	//}

	@Override
	public void saveOrUpdate(Reg reg) {
	if (findByID(reg.getId()) == null){
			userRepository.save(reg);
	}
	else {
			
			
			userRepository.update(reg);
			
		}
			
		}

	@Override
	public Object getAllUnRegUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reg findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
	

	
		
	}

	
	
	
	
		
	

	



	
	

	

	
	

