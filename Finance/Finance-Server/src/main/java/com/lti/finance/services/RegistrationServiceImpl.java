package com.lti.finance.services;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lti.finance.beans.Registration;
import com.lti.finance.dao.RegistrationDao;


@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationDao dao;
	
	
	public RegistrationDao getDao() {
		return dao;
	}


	public void setDao(RegistrationDao dao) {
		this.dao = dao;
	}


	
	
	public long addUser(Registration e) {
		System.out.println("inside Service add");
		return dao.addUser(e);

	}


	public List<Registration> viewUsers() {
		return dao.viewUsers();
	}


	@Override
	public String approveUser(long userId) {
		return dao.approveUser(userId);
	}


	public boolean checkActivation(long userId) {
		return dao.checkActivation(userId);
	}


	@Override
	public String deleteUser(long userId) {
		return dao.deleteUser(userId);
	}
	
	public void upload(MultipartFile file) throws IOException {
		dao.upload(file);
			
		}

}

