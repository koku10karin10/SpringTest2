package com.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.models.Employee;
import com.utility.DBUtil;
@Service
public class EmployeeIndexService {
	EntityManager em = DBUtil.createEntityManager();
	/*&
	public int getPage(int page) {
		return page;
	}*/
	
	public List<Employee> getEmployees(){
	 /*
		int page_count;
	 
	 page_count = 1;
     try{
         page_count = page;
     } catch(NumberFormatException e) { } */
     List<Employee> employees = em.createNamedQuery("getAllEmployees", Employee.class)
                                 /* .setFirstResult(15 * (page_count - 1))
                                  .setMaxResults(15)*/
                                  .getResultList();
     
     return employees;
	}
	
	public long getEmployeesCount() {
		long employees_count = (long)em.createNamedQuery("getEmployeesCount", Long.class)
	            .getSingleResult();
		
		return employees_count;
	}
	
	

     

}
