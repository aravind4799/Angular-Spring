package com.lti.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.lti.finance.beans.BuyProduct;
import com.lti.finance.beans.Product;


@Repository()
public class BuyProductDaoImpl implements BuyProductDao {
	@PersistenceContext
	EntityManager  em;

	@Override
	@Transactional
	public List<BuyProduct> getProductListById(long userId) {
		// TODO Auto-generated method stub
		String sql = "select product from BuyProduct product where userId=:userId";
		Query query = em.createQuery(sql);
		query.setParameter("userId",userId);
		List<BuyProduct> products = (List<BuyProduct>) query.getSingleResult();
		return products;
	}
	
	
	@Transactional
	public double getEmi(int emiScheme,int paidAmount)
	{
		double emi=0;
		if(emiScheme==3)
		{
		int rate=3;
		 emi=paidAmount*rate*(1+rate)*emiScheme/((1+rate)*emiScheme-1);
		 String sql = "alter table buy_product set AMOUNT_PAID_EMI=:emi where EMI_SCHEME=:emiScheme and PAID_AMOUNT=:paidAmount";
		 Query query = em.createQuery(sql);
			query.setParameter("AMOUNT_PAID_EMI",emi);
			query.setParameter("EMI_SCHEME",3);
			query.setParameter("PAID_AMOUNT",paidAmount);
			
			query.executeUpdate();
		
		
	}
		else if(emiScheme==6)
		{
			int rate=6;
			emi=paidAmount*rate*(1+rate)*emiScheme/((1+rate)*emiScheme-1);
			String sql = "alter table buy_product set AMOUNT_PAID_EMI=:emi where EMI_SCHEME=:emiScheme and PAID_AMOUNT=:paidAmount";
			 Query query = em.createQuery(sql);
				query.setParameter("AMOUNT_PAID_EMI",emi);
				query.setParameter("EMI_SCHEME",6);
				query.setParameter("PAID_AMOUNT",paidAmount);
				
				query.executeUpdate();
			
			
		}
		else if(emiScheme==12)
		{
			int rate=12;
			emi=paidAmount*rate*(1+rate)*emiScheme/((1+rate)*emiScheme-1);
			String sql = "alter table buy_product set AMOUNT_PAID_EMI=:emi where EMI_SCHEME=:emiScheme and PAID_AMOUNT=:paidAmount";
			 Query query = em.createQuery(sql);
				query.setParameter("AMOUNT_PAID_EMI",emi);
				query.setParameter("EMI_SCHEME",12);
				query.setParameter("PAID_AMOUNT",paidAmount);
				
				query.executeUpdate();
			
		}
		System.out.println(emi);
		return emi;


}
	
	
	
}
