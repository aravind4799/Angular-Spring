package com.lti.finance.dao;

public interface LoginDao{

	public long ValidateUser(String customerUsername, String customerPassword);
	
	public long ValidateAdmin(String adminUsername, String adminPassword);
}
