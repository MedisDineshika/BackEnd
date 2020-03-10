package com.example.userMgtService.validator;





import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.pharmacy.model.Reg;
import com.pharmacy.service.RegService;

@Component
public  class RegFormValidator implements Validator {

	@Autowired
	RegService regService ;
	
	//@Autowired
	//@Qualifier("emailValidator")
	//EmailValidator emailValidator;

	 private Pattern pattern;    
	 private Matcher matcher;    
	    
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"    
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	@Override
	public boolean supports(Class<?> clazz) {
		return Reg.class.equals(clazz);
	}

	
	@Override
	public void validate(Object target, Errors errors) {
		Reg reg = (Reg) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.regForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.regForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DOB", "NotEmpty.regForm.DOB");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.regForm.gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.regForm.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.regForm.password");
		

		// email validation in spring    
		  if (!(reg.getUserName() != null && reg.getUserName().isEmpty())) {    
		   pattern = Pattern.compile(EMAIL_PATTERN);    
		   matcher = pattern.matcher(reg.getUserName());    
		   if (!matcher.matches()) { errors.rejectValue("userName", "regForm.userName.incorrect");    
		   }    
		  }    
		    
		
		if (reg.getFirstName() == null) {
			errors.rejectValue("firstName", "NotEmpty.regForm.firstName");
		}
		if (reg.getLastName() == null) {
			errors.rejectValue("lastName", "NotEmpty.regForm.lastName");
		}
		
		
		
		if (reg.getDOB() == null) {
			errors.rejectValue("DOB", "NotEmpty.regForm.DOB");
		}
		
		if (reg.getGender() == null) {
			errors.rejectValue("gender", "NotEmpty.regForm.gender");
		}
		
		if (reg.getUserName() == null) {
			errors.rejectValue("userName", "NotEmpty.regForm.userName");
		}
		
		if (reg.getPassword() == null) {
			errors.rejectValue("password", "NotEmpty.regForm.password");
		}
		
			

}

	
}