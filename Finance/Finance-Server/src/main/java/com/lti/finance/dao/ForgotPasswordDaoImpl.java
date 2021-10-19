package com.lti.finance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
public class ForgotPasswordDaoImpl implements ForgotPasswordDao {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	@Transactional
	public String emailVerification(String email,long OTP) {
		String res = "";
		try {
			System.out.println(email);
			String sql = "select userId from Registration where customerEmail=:email";
			Query query = (Query) this.entityManager.createQuery(sql);
			query.setParameter("email", email);
			System.out.println(query.getSingleResult()+"$"+OTP);
			res= query.getSingleResult()+"." + OTP;
		} catch (Exception e) {
			System.out.println("User registered with this "+ email + " not found.");
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	
	@Override
	public String forgotPassword(long userId, String newPassword) {
		String sql = "update Registration set customerPassword=:newPassword where id =:userId";
		Query query = (Query) this.entityManager.createQuery(sql);
		query.setParameter("newPassword", newPassword);
		query.setParameter("userId", userId);
		query.executeUpdate();
		return "Password Updated";
	}
}
