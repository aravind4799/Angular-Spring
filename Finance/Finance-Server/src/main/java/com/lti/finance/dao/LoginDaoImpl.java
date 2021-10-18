package com.lti.finance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public long ValidateUser(String username, String password) {
		long res = 0;
		try {
			String sql = "select userId from Registration where customerUsername=:username and customerPassword=:password";
			Query query = (Query) this.entityManager.createQuery(sql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			res = (long) query.getSingleResult();
			System.out.println(res);
		} catch (Exception e) {
			System.out.println("Invalid Credentials" + e.getMessage());
		}
		return res;
	}

	@Override
	@Transactional
	public long ValidateAdmin(String username, String password) {
		long res = 0;
		try {
			String sql = "select adminId from AdminLogin where adminUsername=:username and adminPassword=:password";
			Query query = (Query) this.entityManager.createQuery(sql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			res = (long) query.getSingleResult();
			System.out.println(res);
		} catch (Exception e) {
			System.out.println("Invalid Credentials" + e.getMessage());
		}
		return res;
	}

}
