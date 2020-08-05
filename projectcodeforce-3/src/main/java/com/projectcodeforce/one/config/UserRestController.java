package com.projectcodeforce.one.config;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@PostConstruct
	public void init() {
		System.out.println("Created");
	}
	@Autowired
private UserServiceImp userService;

	
//	@ResponseBody
//	@GetMapping("/login")
//    public Model login(Model model, String error, String logout) {
//        if (error != null)
//        	
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//       
//
//        return model ; 
//        }
//	
//	
	
	
	
	@ResponseBody
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestParam String emailId, @RequestParam String password) {
		User u= userService.findById(emailId);
		if(u==null) {
			// exception handling
          return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
		}
		if(emailId.equals(u.getEmailId() ) && password.equals(u.getPassword())) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED); //json response 
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		}
	
	
	
	
//	@RequestMapping(path = "/registration", method = RequestMethod.GET)
//	public Model registration(Model model) {
//		User userForm= new User();
//   model.addAttribute("userForm", userForm);
//
//    return model;
//	}


	@PostMapping("/registration")
	public ResponseEntity<Object> registration(@RequestBody User userForm, 
     BindingResult bindingResult, Model model) {
 // userValidator.validate(userForm, bindingResult);

	    if (bindingResult.hasErrors()) {
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); //json respnose 
	    }

    userService.save(userForm);


    return new ResponseEntity<>(userForm,HttpStatus.OK); //json
	}
	
    
    
//	@PostMapping("/userlist/{id}")
//	public Model userlist(Model model, @PathVariable("id") String emailId) {
//		
//		
//		User user= UserService.findById(emailId);
//
//		model.addAttribute(user);
//		//model.addAllAttributes(userService.findAll());
//		//System.out.println("inside userlist mapping");
//		
////		return userService.findAll();
//		return model;
//		
//	}
//	@PostMapping("/AdminDashboard")
//	public Model admindashboard(Model model ) {
//		model.addAllAttributes(userService.findAll());
//		return model;
//		
//	}



}
