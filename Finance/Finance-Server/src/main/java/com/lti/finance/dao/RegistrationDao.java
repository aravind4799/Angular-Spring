package com.lti.finance.dao;



import java.util.List;

import com.lti.finance.beans.Registration;


public interface RegistrationDao {
	
	

	public long addUser(Registration e);
	
	//return list of users for admin to approve
	public List<Registration> viewUsers();
	
	//approve the user using userId
	public String approveUser(long userId);
	

}
