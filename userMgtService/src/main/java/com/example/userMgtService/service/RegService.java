package com.example.userMgtService.service;

import java.util.List;

import com.example.userMgtService.model.Reg;

//import org.codehaus.jettison.json.JSONException;



public interface RegService {

	//Checking login details 
	Reg checkLogin(String userName, String password);
	
	
	
	Reg checkUser (String userName);
	
	
	

	Reg findByID(int id);

	//void save(RoleType roleType);

	
	
    // save ;
	
	void save(Reg reg);
	
	
	
	
	
	
	
	List<Reg> getAllUnRegUsers();



	//void update(Reg reg);



	void saveOrUpdate(Reg reg);

	List<Reg> findAll();



	void delete(int id);
	

	//Reg findAll();
	

	//void save (Reg reg2);

	//void saveOrUpdate(Reg reg);
	
	
}


