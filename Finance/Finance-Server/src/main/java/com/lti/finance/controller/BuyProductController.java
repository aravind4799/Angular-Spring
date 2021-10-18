package com.lti.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.finance.beans.BuyProduct;
import com.lti.finance.services.BuyProductServiceImpl;




@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("buyproduct")
public class BuyProductController {
	
	@Autowired
	BuyProductServiceImpl BuyProductService;
	

	
	@GetMapping("/{user_id}")
	public List<BuyProduct> getProductDetailsById(@PathVariable("user_id") long userId ) {
		return BuyProductService.getProductListById(userId);
	}
	
//	@GetMapping("/")
//	public List<BuyProduct> getProductDetailsById() {
//		return BuyProductService.getProductList();
//	}
	
	
	@GetMapping("/{emi_scheme}/{paid_amount}")
	public double getEmi(@RequestParam("EMI_SCHEME")int emiScheme,@RequestParam("PAID_AMOUNT")int paidAmount)
	{
		return BuyProductService.getEmi(emiScheme, paidAmount);
	}
	
	
	
	

	
	

}