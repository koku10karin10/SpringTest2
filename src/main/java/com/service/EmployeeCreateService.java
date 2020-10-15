package com.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.models.Employee;
import com.utility.DBUtil;

@Service
@Transactional
public class EmployeeCreateService {
	public void createEmployee(Employee e) {
		EntityManager em = DBUtil.createEntityManager();

		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		em.close();

		
	}

}


