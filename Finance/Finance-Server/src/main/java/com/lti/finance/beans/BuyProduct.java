package com.lti.finance.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity()
@Table(name="Buy_product")
public class BuyProduct {
	
	@Id
	@Column(name="transaction_id")
	@GeneratedValue(generator="TRANSACTION_ID_SEQ")
	@SequenceGenerator(name="TRANSACTION_ID_SEQ",sequenceName="TRANSACTION_ID_SEQ", allocationSize=100)
	private long transactionId;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="emi_scheme")
	private int emiScheme;
	
	@Column(name="order_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Column(name="paid_amount")
	private int paidAmount;
	
	@Column(name="product_id")
	private int productId;
	
	public BuyProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyProduct(long userId, int emiScheme, Date orderDate, int paidAmount, int productId) {
		super();
		this.userId = userId;
		this.emiScheme = emiScheme;
		this.orderDate = orderDate;
		this.paidAmount = paidAmount;
		this.productId = productId;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getEmiScheme() {
		return emiScheme;
	}

	public void setEmiScheme(int emiScheme) {
		this.emiScheme = emiScheme;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "BuyProduct [transactionId=" + transactionId + ", userId=" + userId + ", emiScheme=" + emiScheme
				+ ", orderDate=" + orderDate + ", paidAmount=" + paidAmount + ", productId=" + productId + "]";
	}
	
	




	
	
	
	
	
	
	
	

}
