package com.lti.finance.controller;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.finance.services.ForgotPasswordService;
import com.lti.finance.services.MailService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("login")
public class ForgotPasswordController {

	@Autowired
	private MailService notificationService;

	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	public long generateOTP() {
		final int LENGTH = 8;
		SecureRandom randomizer = new SecureRandom();
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < LENGTH; i++) {
		   builder.append(randomizer.nextInt(10));
		}

		long otp=Long.parseLong(builder.toString()); 
		return otp;
	}
//	
//	@PostMapping("/send-mail")
//	public String registrationConfirmation() {
//		try {
//			notificationService.sendEmailForConfirmation(registration);
//		} catch (MailException mailException) {
//			System.out.println(mailException);
//		}
//		return "Congratulations! Your mail has been send to the user.";
//	}

	@PostMapping("/verify")
	public String emailVerification(@RequestBody String email) {
		System.out.println(email);
		long OTP = generateOTP();
//		notificationService.sendEmailForOTP(email,OTP);
		return forgotPasswordService.emailVerification(email,OTP);
	}
	
	
	
	@PostMapping("/update-password")
	public String changePassword(@RequestBody long userId, String newPassword) {
		return forgotPasswordService.forgotPassword(userId, newPassword);
	}
}
