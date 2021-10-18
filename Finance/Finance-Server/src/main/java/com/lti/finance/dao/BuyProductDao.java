package com.lti.finance.dao;

import java.util.List;

import com.lti.finance.beans.BuyProduct;

public interface BuyProductDao {
	
	List<BuyProduct> getProductListById(long userId);
	public double getEmi(int emiScheme,int paidAmount);

	


}
