package com.lti.finance.services;

import org.springframework.stereotype.Service;

import com.lti.finance.beans.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	// once Id is generated user get mail with id number
	public void sendEmailForOTP(String email, long OTP) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("OTP for reseting the password");
		mail.setText("Your OTP for reseting password is " + OTP);
		javaMailSender.send(mail);
	}

	public void sendEmailForConfirmation(Registration registration) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(registration.getCustomerEmail());
		mail.setSubject("You have been successfully registered with us.");
		mail.setText("You are successfully registered with id: " + registration.getUserId()
				+ ". Please keep this for further reference. You can login via username and password.");
		javaMailSender.send(mail);
	}
}
