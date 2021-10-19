package com.lti.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.finance.beans.Registration;

//Spring Stereotype-

@Repository
public class RegistrationDaoImpl implements RegistrationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public long addUser(Registration e) {
		System.out.println("inside dao");

		try {

			em.persist(e);
			System.out.println("added");

		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		return e.getUserId();
	}

	@Override
	@Transactional
	public List<Registration> viewUsers() {
		String sql = "select users from Registration users";
		Query query = em.createQuery(sql);
		List<Registration> userList = query.getResultList();
		return userList;
	}

	@Override
	@Transactional
	public String approveUser(long userId) {
		String sql = "update Registration set activation=:approve where id =:userId";
		Query query = (Query) this.em.createQuery(sql);
		query.setParameter("approve", "true");
		query.setParameter("userId", userId);
		query.executeUpdate();
		return "User Approved";
	}

}
