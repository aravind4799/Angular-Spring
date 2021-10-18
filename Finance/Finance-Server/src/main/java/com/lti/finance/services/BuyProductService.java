package com.lti.finance.services;




import java.util.List;

import com.lti.finance.beans.BuyProduct;


public interface BuyProductService {
	List<BuyProduct> getProductListById(long userId);
	public double getEmi(int emiScheme,int paidAmount);
}
