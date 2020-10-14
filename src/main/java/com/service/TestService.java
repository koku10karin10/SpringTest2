package com.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.models.Test;
import com.utility.DBUtil;

@Service
public class TestService {
	public List<Test> getTests(){
	EntityManager em = DBUtil.createEntityManager();
	List<Test> tl = em.createNamedQuery("getAllTests", Test.class)
						.getResultList();
	return tl;
	
	}

}
