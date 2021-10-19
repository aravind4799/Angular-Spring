package com.lti.finance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.finance.dao.ForgotPasswordDao;


@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

	@Autowired
	private ForgotPasswordDao forgotPasswordDao;

	public ForgotPasswordDao getForgotPasswordDao() {
		return forgotPasswordDao;
	}

	public void setForgotPasswordDao(ForgotPasswordDao forgotPasswordDao) {
		this.forgotPasswordDao = forgotPasswordDao;
	}

	@Override
	public String forgotPassword(long userId, String newPassword) {
		return forgotPasswordDao.forgotPassword(userId, newPassword);
	}

	@Override
	public String emailVerification(String email,long OTP) {
		return forgotPasswordDao.emailVerification(email,OTP);
	}

}
