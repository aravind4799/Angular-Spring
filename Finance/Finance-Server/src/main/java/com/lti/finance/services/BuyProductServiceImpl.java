package com.lti.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.finance.beans.BuyProduct;
import com.lti.finance.dao.BuyProductDao;

@Service("buyproductService")
public class BuyProductServiceImpl implements BuyProductService {
	@Autowired
	BuyProductDao dao;

//	@Override
//	public List<BuyProduct> getProductListById(long userId) {
//		List<BuyProduct> productlist = dao.getProductListById(userId);
//		return productlist;
//	}
	@Override
	public List<BuyProduct> getProductListById(long userId) {
		List<BuyProduct> products = dao.getProductListById(userId);
		return products;
	}

}
