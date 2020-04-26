package com.example.userMgtService.service;



import java.util.Optional;

import com.example.userMgtService.model.Reg;

//import org.codehaus.jettison.json.JSONException;



public interface RegService {

	//Checking login details 
	Reg checkLogin(String userName, String password);
	
	
	
	Reg checkUser (String userName);
	
	
	

	
	//void save(RoleType roleType);

	
	
    // save ;
	
	void save(Reg reg);
	
	
	
	
	
	
	
	



	//void update(Reg reg);



	void saveOrUpdate(Reg reg);

	


	



	Reg findByID(Long id);



	Object getAllUnRegUsers();



	Optional<Reg> findByID(long id);
	

	//Reg findAll();
	

	//void save (Reg reg2);

	//void saveOrUpdate(Reg reg);
	
	
}


