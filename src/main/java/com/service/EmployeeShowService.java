package com.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.models.Employee;
import com.utility.DBUtil;

@Service
public class EmployeeShowService {
	public Employee show(int id) {
		EntityManager em = DBUtil.createEntityManager();

        Employee e = em.find(Employee.class, id);

        em.close();

        return e;

        
	}

}
