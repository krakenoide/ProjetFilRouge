package com.springmvc.daoimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.SonDao;
import com.springmvc.modeles.Son;

@Repository 
public class SonDaoImplementation implements SonDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Transactional
	public Son get1(int id) {
		Session session =sessionfactory.getCurrentSession();	
		Son m=session.get(Son.class, id);
		return m;
	}
}
