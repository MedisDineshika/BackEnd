package com.example.userMgtService.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.userMgtService.model.Reg;
import com.example.userMgtService.service.RegService;
import com.example.userMgtService.validator.LoginformValidator;
import com.example.userMgtService.validator.RegFormValidator;




@Controller
@Transactional
public class MainController {

	@Autowired 
	RegService regService ;
	
	
	@Autowired
	RegFormValidator regFormValidator ;
	
	@Autowired
	LoginformValidator loginformValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(regFormValidator);
	}
	
	@InitBinder
	protected void initBinder1(WebDataBinder binder) {
		binder.setValidator(loginformValidator);
	}
	
	
	//DisplayLogin form
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	 public String showLoginForm(Model model) {

			Reg reg = new Reg();
			model.addAttribute("loginForm", reg);
			return "LoginForm";
		}
		
   //Check login details and give access to the system based on privileges
	   @RequestMapping(value = "/login/add" ,method = RequestMethod.POST)
	   public String processForm(@ModelAttribute("loginForm") @Validated Reg reg, BindingResult result,
	   HttpSession httpSession , Model model,final RedirectAttributes redirectAttributes	) {
					
		   if (result.hasErrors()) {
					return "LoginForm";
						
				} else {
				
							Reg userExists = regService.checkLogin(reg.getUserName(),reg.getPassword());
							if(userExists ==null){
									throw new UserNotFoundException();
							  }
							else
							  { 
									httpSession.setAttribute("reg", userExists);
												
									model.addAttribute("reg",userExists);
									@SuppressWarnings("unused")
									//Get the type of User
									String userType = reg.getRole_Type();
									return "showReg";
								}
					 }		
		}
	//Displaying an error message when logging details were not matched 			
		@ExceptionHandler(UserNotFoundException.class)
		public ModelAndView handleStudentNotFoundException(UserNotFoundException ex) {
				  Map<String, String> model = new HashMap<String, String>();
				  model.put("exception", ex.toString());
				  return new ModelAndView("error", model);
		}
		
		@RequestMapping(value = "/reg", method = RequestMethod.GET)
		public String showREgForm(Model model) {

			

			Reg reg = new Reg();
			
			model.addAttribute("regForm", reg);


			return "RegForm";
		}

		
		//@RequestMapping(value = "/reg/add", method = RequestMethod.POST)
	//	public String saveReg(@ModelAttribute("regForm") @Validated Reg reg ,BindingResult result, Model model ,
		//		final RedirectAttributes redirectAttributes	) {
		//	if (result.hasErrors()) {
				
			//	return "RegForm";
		//	} else {
			
			//      model.addAttribute("firstName", reg.getFirstName());
			  //    model.addAttribute("lastName",reg.getLastName());
			    //  model.addAttribute("DOB",reg.getDOB());
			      
			      
			   // model.addAttribute("gender", reg.getGender());
			     
			     // model.addAttribute("userName",reg.getUserName());
			     //model.addAttribute("password", reg.getPassword());

			      //regService.save(reg);
			      
			      //return "redirect:/reg/add/" + reg.getId() ;

			   //}
		
		//}

		@RequestMapping(value = "/reg/add", method = RequestMethod.POST)
			public String saveReg(@ModelAttribute("regForm") @Validated Reg reg ,BindingResult result,HttpSession httpSession, Model model ,
					final RedirectAttributes redirectAttributes	) {
				if (result.hasErrors()) {
					return "RegForm";
					}
				else{
					
					Reg userNameExists = regService.checkUser(reg.getUserName());
					if(userNameExists != null){
						httpSession.setAttribute("reg", userNameExists);
						model.addAttribute("reg",userNameExists);
						return "userError";		
					}
					else{
									
				     // model.addAttribute("firstName", reg.getFirstName());
				     // model.addAttribute("lastName",reg.getLastName());
				  //    model.addAttribute("DOB",reg.getDOB());
				      
				      
				   // model.addAttribute("gender", reg.getGender());
				     
				     // model.addAttribute("userName",reg.getUserName());
				    // model.addAttribute("password", reg.getPassword());

				      
				   //  regService.save(reg);
				  regService.saveOrUpdate(reg);
				      return "redirect:/reg/add/" + reg.getId() ;  
				       }
		
			}
				
	
	}
		@RequestMapping(value = "/reg/add/{id}", method = RequestMethod.GET)
		public String showFilledREg(@PathVariable("id") int id, Model model) {

		
			Reg reg =regService.findByID(id);
			
			model.addAttribute("reg",reg);

			return "InitialRegShow";

		}
		
		
		
		@RequestMapping(value = "/login/add/{id}", method = RequestMethod.GET)
		public String showRegUser(@PathVariable("id") int id, Model model) {

		
			Reg reg =regService.findByID(id);
			
			model.addAttribute("reg",reg);

			return "showReg";

		}
		
		// show update form
				@RequestMapping(value = "/login/add/{id}/update", method = RequestMethod.GET)
				public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

					
				Reg reg = regService.findByID(id);
					model.addAttribute("regForm", reg);
					
					return "RegForm";

				}
		
				 
				//list page
				 
				 @RequestMapping(value = "/login/users", method = RequestMethod.GET)
					
				 public String AllUsersForm(Model model) {

					
						
							model.addAttribute("users", regService.findAll());
							return "list";

						
					}

						

				//delete user
					@RequestMapping(value = "/login/users/{id}/delete", method = RequestMethod.POST)
					public void deleteUser(@PathVariable("id") int id, 
						final RedirectAttributes redirectAttributes) {

						

					regService.delete(id);
					
						
						

					}
	
				
		
		
		// show update formToday
		//@RequestMapping(value = "/login/add/{id}/update", method = RequestMethod.GET)
//		public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

			
	//	Reg reg = regService.findByID(id);
		//	model.addAttribute("regForm", reg);
			
			//return "RegForm";

		//}
		
		
		// save update form
			//@RequestMapping(value = "/login/add/{id}/update/save", method = RequestMethod.POST)
			//	public void saveUpdateUserForm(@PathVariable("id") int id,  @Validated Reg regUser) {

					
						//Reg reg = regService.findByID(id);
						//reg.setContactNo(regUser.getContactNo());
						//reg.setOrgName(regUser.getOrgName());
		
						//regService.update(reg);
			//}
		//show update form
		//@RequestMapping(value = "/add/{id}/update/save", method = RequestMethod.POST)
		//	public void saveUpdateUserForm(@PathVariable("id") int id , @ModelAttribute("updateForm") Reg reg2 ,BindingResult result,HttpSession httpSession, Model model ,
				//	final RedirectAttributes redirectAttributes	) {

				
			//Reg reg = regService.findByID(id);
			
			//reg.setPassword(reg2.getPassword());
			//reg.setUserName(reg2.getUserName());
			//reg.setGender(reg2.getGender());
			//reg.setDOB(reg2.getDOB());
			//reg.setLastName(reg2.getLastName());
			//reg.setFirstName(reg2.getFirstName());
			
			
			
		    // regService.save(reg);
			

			//}
		
		
		
	
		
		
		
		
		//Processing logging out from the system

		@RequestMapping(value = "/login/out" ,method = RequestMethod.GET)
		public String processOUT( @ModelAttribute("loginForm")  Reg reg, BindingResult result,HttpSession httpSession , Model model
				) {
			
				
					@SuppressWarnings("unused")
					Reg userExistshttpSession = (Reg)httpSession.getAttribute("reg");
					
					//((HttpSession) userExistshttpSession).invalidate();
						
					httpSession.invalidate();
					
					
					return "redirect:/";
			
						
					
		}
	
		@RequestMapping(value = "/login/ViewReports", method = RequestMethod.GET)
		public ModelAndView showReport1( Model model) {

			 return new ModelAndView ("StockReport");
			
			
			
		
		}
		@RequestMapping(value = "/login/add/AllowPermission", method = RequestMethod.GET)
		public String showUnPermitted( Model model) {

			model.addAttribute("UnPermissionList", regService.getAllUnRegUsers());
			return "Permission";
			
			
			
		
		}

}


