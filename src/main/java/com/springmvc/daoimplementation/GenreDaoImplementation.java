package com.springmvc.daoimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.GenreDao;
import com.springmvc.modeles.Genre;

@Repository
public class GenreDaoImplementation implements GenreDao{
	@Autowired
	private SessionFactory sessionfactory;
	
	@Transactional
	public Genre get1(int id) {
		Session session =sessionfactory.getCurrentSession();	
		Genre a=session.get(Genre.class, id);
		return a;
	}

	@Transactional
	public void ajout1(Genre g) {
		Session session =sessionfactory.getCurrentSession();
		session.save(g);
	}
	
	@Transactional
	public void supp1(Genre g) {
		Session session =sessionfactory.getCurrentSession();
		session.remove(g);
	}

}
