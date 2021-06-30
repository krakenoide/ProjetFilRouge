package com.springmvc.daoimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.AlbumDao;
import com.springmvc.modeles.Album;

@Repository
public class AlbumDaoImplementation implements AlbumDao{
	@Autowired
	private SessionFactory sessionfactory;
	
	
	@Transactional
	public Album get1(int id) {
		Session session =sessionfactory.getCurrentSession();	
		Album a=session.get(Album.class, id);
		return a;
	}

	@Transactional
	public void ajout1(Album a) {
		Session session =sessionfactory.getCurrentSession();
		session.save(a);
	}
	
	@Transactional
	public void supp1(Album a) {
		Session session =sessionfactory.getCurrentSession();
		session.remove(a);
	}
}
