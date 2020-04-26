package com.example.accountMgtService.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountMgtService.dao.AccountRepository;
import com.example.accountMgtService.model.SellingOrder;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository ;

	//@Transactional
	//public Optional<SellingOrder> getByPid(Long pId) {
	//	return accountRepository.findById(pId);
	//}

	public Optional<SellingOrder> getById(Long id) {
		return accountRepository.findById(id);
	}
	
}
