package com.example.accountMgtService.Contoller;





import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.example.accountMgtService.model.SellingOrder;
import com.example.accountMgtService.service.AccountService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
//@RequestMapping("/services")
//@RestController
public class AccountMgtContoller {

	@Autowired 
	AccountService accountService ;
	
	
	
	
	//@PostMapping("/bill")
	//public SellingOrder saveProduct(@RequestBody SellingOrder sellingOrder) {
	   //     return accountService.save(sellingOrder);
	   // }
	
	//@GetMapping("/bill")
	//public Optional<SellingOrder> findById(Long id) {

	  //  return accountRepository.findById(id);
	//}
	//@RequestMapping("/accountMgtService/{pId}")
	//@GetMapping("/bill/{pId}")
	//public Optional<SellingOrder> getProduct(@PathVariable Long pId) {

		 // return accountService.getByPid(pId);
	//}
	
	//@RequestMapping("/accountMgtService/{id}")
	//@GetMapping("/bill/{id}")
	//public Optional<SellingOrder> getProduct(@PathVariable Long id) {

		// return accountService.getById(id);
	//}
	
	@GetMapping("/bill/{id}")
    public ResponseEntity<Optional<SellingOrder>> getProduct(@PathVariable(value = "id") Long id)
         {
       Optional<SellingOrder> sellingOrder= accountService.getById(id);
        
        return ResponseEntity.ok().body(sellingOrder);
    }

	
}
