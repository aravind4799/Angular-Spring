package com.lti.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.finance.beans.ApproveUser;
import com.lti.finance.beans.Registration;
import com.lti.finance.services.RegistrationService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminApprovalController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/all-users")
	public List<Registration> viewAllUSers() {
		return registrationService.viewUsers();
	}
	
	@PostMapping("/approve-user/{user-id}")
	public String approveUser(@PathVariable(value = "user-id") long userId) {
		System.out.println(userId);
//		System.out.println(approve);
//		if(approve=="true") {
		return registrationService.approveUser(userId);
//		}
//		else {
//			return "Not Approved";
//		}
	}
}
