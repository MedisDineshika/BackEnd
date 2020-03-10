package com.example.userMgtService.dao;

import java.util.List;

import com.example.userMgtService.model.Reg;


public interface RegDao {

	
	//Checking login details 
	Reg checkLogin(String userName, String password);

	
	
	
	void save(Reg reg);

	Reg findByID(int id);

	Reg checkUser(String userName);
	

	//void save(RoleType roleType);

	void update(Reg reg);

	List<Reg> getAllUnRegUsers();




	List<Reg> findAll();




	void delete(int id);

	
	
	//Reg checkRole(Reg userExists );
	
	

	//void update(Reg reg);

	//Reg update(Reg reg);

	//Reg update(Reg reg, Object userName);

	//void update(Reg reg, Object userName, Object password); 
	
	
}
