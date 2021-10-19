package com.lti.finance.beans;

public class ApproveUser {

	long userId;
	String approve;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public ApproveUser(long userId, String approve) {
		super();
		this.userId = userId;
		this.approve = approve;
	}
	@Override
	public String toString() {
		return "ApproveUser [userId=" + userId + ", approve=" + approve + "]";
	}
	
	public ApproveUser() {
		super();
	}
}
