package com.lti.finance.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lti.finance.beans.Registration;
import com.lti.finance.services.RegistrationServiceImpl;




@CrossOrigin("*")
@RestController
@RequestMapping("user")
public class RegistrationController {

	@Autowired
	RegistrationServiceImpl registrationService;

	// http://localhost:8091/user/registration
	
	@PostMapping("/registration")
	public long addUser(@RequestBody Registration registration) {
		return registrationService.addUser(registration);
	}
	
	@GetMapping("/check-activation/{user-id}")
	public boolean checkActivation(@PathVariable(value = "user-id") long userId) {
		return registrationService.checkActivation(userId);
	}
	
	@GetMapping("delete-user/{user-id}")
	public String deleteUser(@PathVariable(value = "user-id") long userId) {
		return registrationService.deleteUser(userId);
	}
	
	
	@PostMapping("/upload")
	  public void upload(@RequestParam MultipartFile file) throws IOException {
		registrationService.upload(file);
	  }

}
