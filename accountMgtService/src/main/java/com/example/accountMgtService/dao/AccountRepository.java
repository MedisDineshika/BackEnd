package com.example.accountMgtService.dao;





import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accountMgtService.model.SellingOrder;

public interface AccountRepository extends  JpaRepository<SellingOrder,Long> {

	Optional<SellingOrder> findById(Long pId);
	
	
	

	

   

	
}
