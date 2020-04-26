package com.example.userMgtService.validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.userMgtService.model.Reg;
import com.example.userMgtService.service.RegService;


@Component
public class LoginformValidator implements Validator {

	@Autowired
	RegService regService ;
	

	public boolean supports(Class<?> clazz) {
		return Reg.class.equals(clazz);
	}

	
	@Override
	public void validate(Object target, Errors errors) {
		Reg reg = (Reg) target;

		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.loginForm.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.loginForm.password");
		

		
		
		
		if (reg.getUserName() == null) {
			errors.rejectValue("userName", "NotEmpty.loginForm.userName");
		}
		
		if (reg.getPassword() == null) {
			errors.rejectValue("password", "NotEmpty.loginForm.password");
		}
		
			

}

}