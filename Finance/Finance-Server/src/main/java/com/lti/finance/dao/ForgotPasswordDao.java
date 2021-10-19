package com.lti.finance.dao;

public interface ForgotPasswordDao {

	public String forgotPassword(long userId, String newPassword);
	public String emailVerification(String email,long OTP);
}
