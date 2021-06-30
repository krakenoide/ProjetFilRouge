package com.springmvc.daoimplementation;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.MorceauDao;
import com.springmvc.modeles.Morceau;

//@Component
@Repository //annotation spring pour les dao (classes qui vont interoger la db)
public class MorceauDaoImplementation implements MorceauDao{
	@Autowired
	private SessionFactory sessionfactory;
	
	@Transactional
	public Morceau get1(int id) {
		Session session =sessionfactory.getCurrentSession();	
		Morceau m=session.get(Morceau.class, id);
		return m;
	}

	@Transactional
	public void ajout1(Morceau m) {
		Session session=sessionfactory.getCurrentSession();
		session.save(m);		
	}

	@Transactional
	public void supp1(Morceau m) {
		Session session=sessionfactory.getCurrentSession();
		session.remove(m);
	}
	
	@Transactional    
	public void update1(Morceau m) {
        Session session=sessionfactory.getCurrentSession();
        session.update(m);
    }


}
