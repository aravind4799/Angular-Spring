package com.lti.finance.dao;



import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lti.finance.beans.Registration;


public interface RegistrationDao {
	
	

	public long addUser(Registration e);
	
	//return list of users for admin to approve
	public List<Registration> viewUsers();
	
	//approve the user using userId
	public String approveUser(long userId);
	
	// check if user is activated
	public boolean checkActivation(long userId);
	
	//delete user from the table
	public String deleteUser(long userId);
	
	
	//fileuploading
	public void upload(@RequestParam MultipartFile file) throws IOException;

}
