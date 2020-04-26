package com.example.userMgtService.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userMgtService.model.Reg;



public interface UserRepository extends  JpaRepository<Reg,Long>{

	void update(Reg reg);

	Reg checkUser(String userName);

	Reg findById(Integer id);

	
	Reg checkLogin(String userName, String password);
	
	

	
}
