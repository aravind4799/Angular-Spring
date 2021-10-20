package com.lti.finance.services;



import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lti.finance.beans.Registration;


public interface RegistrationService {

	public long addUser(Registration e);
	public List<Registration> viewUsers();
	public String approveUser(long userId);
	public boolean checkActivation(long userId);
	public String deleteUser(long userId);
	public void upload(@RequestParam MultipartFile file) throws IOException;
}
