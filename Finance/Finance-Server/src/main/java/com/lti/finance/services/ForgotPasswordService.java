package com.lti.finance.services;

public interface ForgotPasswordService {
	public String forgotPassword(long userId, String newPassword);
	public String emailVerification(String email,long OTP);
}
