package com.lti.finance.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@Column(name="product_id")
	@GeneratedValue(generator="product_id_seq")
	@SequenceGenerator(name="product_id_seq",sequenceName="product_id_seq", allocationSize=100)
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_cost")
	private int productCost;
	
	@Column(name="product_image")
	private String productImage;
	
	@Column(name="product_description")
	private String productDescription;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, int productCost, String productImage, String productDescription) {
		super();
		this.productName = productName;
		this.productCost = productCost;
		this.productImage = productImage;
		this.productDescription = productDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productImage=" + productImage + ", productDescription=" + productDescription + "]";
	}
	
	

	
	
	
	
	
 

}
