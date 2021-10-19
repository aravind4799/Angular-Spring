package com.lti.finance.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name="REGISTRATION")
public class Registration {
	
	@Id
	@GeneratedValue(generator="user_id")
	@SequenceGenerator(name="user_id",sequenceName="USER_ID_SEQUENCE",allocationSize=1)
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="CUSTOMER_PHONE")
	private long customerPhone;
	
	@Column(name="CUSTOMER_EMAIL")
	private String customerEmail;
	
	
	@Column(name="CUSTOMER_USERNAME")
	private String customerUsername;
	
	@Column(name="CUSTOMER_PASSWORD")
	private String customerPassword;
	
	@Column(name="CUSTOMER_ADDRESS")
	private String customerAddress;
	
	@Column(name="CARD_TYPE")
	private String cardType;
	
	@Column(name="CUSTOMER_BANK")
	private String customerBank;
	
	@Column(name="CUSTOMER_ACCOUNT_NO")
	private long customerAccountNo;
	
	@Column(name="CUSTOMER_IFSC")
	private String customerIfsc;
	
	@Column(name="ACTIVATION")
	private String activation;
	
	//relationship with admin login table
	
	

	public Registration() {
		super();
	}

	public Registration(long userId, String customerName, long customerPhone, String customerEmail,
			String customerUsername, String customerPassword, String customerAddress, String cardType,
			String customerBank, long customerAccountNo, String customerIfsc, String activation) {
		super();
		this.userId = userId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
		this.cardType = cardType;
		this.customerBank = customerBank;
		this.customerAccountNo = customerAccountNo;
		this.customerIfsc = customerIfsc;
		this.activation = activation;
		
	}
	
	

	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCustomerBank() {
		return customerBank;
	}

	public void setCustomerBank(String customerBank) {
		this.customerBank = customerBank;
	}

	public long getCustomerAccountNo() {
		return customerAccountNo;
	}

	public void setCustomerAccountNo(long customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}

	public String getCustomerIfsc() {
		return customerIfsc;
	}

	public void setCustomerIfsc(String customerIfsc) {
		this.customerIfsc = customerIfsc;
	}

	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}
	

	

	

	@Override
	public String toString() {
		return "Registration [userId=" + userId + ", customerName=" + customerName + ", customerPhone=" + customerPhone
				+ ", customerEmail=" + customerEmail + ", customerUsername=" + customerUsername + ", customerPassword="
				+ customerPassword + ", customerAddress=" + customerAddress + ", cardType=" + cardType
				+ ", customerBank=" + customerBank + ", customerAccountNo=" + customerAccountNo + ", customerIfsc="
				+ customerIfsc + ", activation=" + activation + "]";
	}

	
	
	
	

}
