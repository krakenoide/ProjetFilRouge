package com.springmvc.daoimplementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UtilisateurDao;
import com.springmvc.modeles.Album;
import com.springmvc.modeles.Artiste;
import com.springmvc.modeles.Role;
import com.springmvc.modeles.RolePK;
import com.springmvc.modeles.Utilisateur;

@Repository
public class UtilisateurDaoImplementation implements UtilisateurDao {
	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	public void addUtilisateur(Utilisateur u) {

		Session session = sessionfactory.getCurrentSession();
		String BCryptedPwrd = BCrypt.hashpw(u.getMotDePasse(), BCrypt.gensalt());
		String insertUser = "INSERT INTO users VALUES ('"+u.getNomDeCompte()+"','{bcrypt}"+BCryptedPwrd+"',1);";	
		String insertRole = "INSERT INTO authorities VALUES ('"+u.getNomDeCompte()+"','ROLE_USER');";
		
		session.createSQLQuery(insertUser).executeUpdate();
		session.createSQLQuery(insertRole).executeUpdate();
	
	}

	@Transactional
	public void removeUtilisateur(Utilisateur u) {
		Session session = sessionfactory.getCurrentSession();
		session.remove(u);
	}

	@Transactional
	public void updateUtilisateur(Utilisateur u, String nom_de_compte, String mot_de_passe) {
		Session session = sessionfactory.getCurrentSession();
		u.setMotDePasse(mot_de_passe);
		u.setNomDeCompte(nom_de_compte);
		session.update(u);
	}

	@Transactional
	public Utilisateur getUtilisateur(int id) {

		Session session = sessionfactory.getCurrentSession();
		Utilisateur u = session.get(Utilisateur.class, id);
		return u;
	}

	@Transactional
	public List<Utilisateur> getAllUtilisateurs() {
		return this.sessionfactory.getCurrentSession().createQuery("FROM Utilisateur").getResultList();
	}

	@Transactional
	public Utilisateur getUtilisateurDepuisNom(String name) {
		Query q = this.sessionfactory.getCurrentSession().createQuery("FROM Utilisateur WHERE nomDeCompte = :s",
				Utilisateur.class);
		q.setParameter("s", name);
		List<Utilisateur> l = q.getResultList();

		if (l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

}
