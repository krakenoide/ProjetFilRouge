package com.springmvc.daoimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.PlaylistDao;
import com.springmvc.modeles.Playlist;
import com.springmvc.modeles.Utilisateur;
@Repository
public class PlaylistDaoImplementation implements PlaylistDao{
	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	public void addPlaylist(Playlist p) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.getCurrentSession();
		session.save(p);
	
	}

	@Transactional
	public void removePlaylist(Playlist p) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.getCurrentSession();
		session.remove(p);
	
	}

	@Transactional
	public void updatePlaylist(Playlist p,String titre) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.getCurrentSession();
		p.setTitre(titre);
		session.update(p);
	}

	@Transactional
	public Playlist getPlaylist(int id) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.getCurrentSession();	
		Playlist p=session.get(Playlist.class, id );
		return p;
		
	}


}
