package com.example.userMgtService.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.userMgtService.dao.RegDao;
import com.example.userMgtService.model.Reg;

//import com.fasterxml.jackson.databind.util.JSONPObject;


@Service
@Transactional

public class RegServiceImpl implements RegService {

	
	@Autowired
	RegDao regDao;
	
	
	//Checking login details 
	@Override
	public Reg checkLogin(String userName, String password) {
		
		return regDao.checkLogin(userName, password);
		
	}

	@Override
	public void save(Reg reg) {
		//reg.setPassword(bCryptPasswordEncoder.encode(reg.getPassword()));
		regDao.save(reg);
		
	}

	@Override
	public Reg findByID(int id) {
		return regDao.findByID(id)	;
	}

	@Override
	public Reg checkUser(String userName) {
		return regDao.checkUser(userName);
	}

	//@Override
	//public void save(RoleType roleType) {
	//	regDao.save(roleType);
		
	//}

	@Override
	public void saveOrUpdate(Reg reg) {
	if (findByID(reg.getId()) == null){
			regDao.save(reg);
	}
	else {
			
			
			regDao.update(reg);
			
		}
			
		}

	@Override
	public List<Reg> getAllUnRegUsers() {
		return regDao.getAllUnRegUsers();
	}

	@Override
	public List<Reg> findAll() {
		return regDao.findAll();
	}

	@Override
	public void delete(int id) {
		
			regDao.delete(id);
		}

		
	}

	
	
	
	
		
	

	



	
	

	

	
	

