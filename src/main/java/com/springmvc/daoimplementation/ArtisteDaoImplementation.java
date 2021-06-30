package com.springmvc.daoimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.ArtisteDao;
import com.springmvc.modeles.Artiste;

@Repository
public class ArtisteDaoImplementation implements ArtisteDao{
	@Autowired
	private SessionFactory sessionfactory;
	
	@Transactional
	public Artiste get1(int id) {
		Session session =sessionfactory.getCurrentSession();	
		Artiste a=session.get(Artiste.class, id);
		return a;
	}

	@Transactional
	public void ajout1(Artiste a) {
		Session session =sessionfactory.getCurrentSession();
		session.save(a);
	}
	
	@Transactional
	public void supp1(Artiste a) {
		Session session =sessionfactory.getCurrentSession();
		session.remove(a);
	}

}
