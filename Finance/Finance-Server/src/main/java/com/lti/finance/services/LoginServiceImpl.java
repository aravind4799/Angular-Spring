package com.lti.finance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.finance.dao.LoginDao;



@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public long ValidateUser(String customerUsername, String customerPassword){
		System.out.println("INside Service login");
		return loginDao.ValidateUser(customerUsername, customerPassword);
	}

	
	
	public long ValidateAdmin(String adminUsername, String adminPassword) {
		System.out.println("INside Service login");
		return loginDao.ValidateAdmin(adminUsername, adminPassword);
	}

}
