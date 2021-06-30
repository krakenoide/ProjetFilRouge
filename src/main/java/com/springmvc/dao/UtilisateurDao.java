package com.springmvc.dao;

import java.util.List;

import com.springmvc.modeles.Utilisateur;

public interface UtilisateurDao {
	
	public void addUtilisateur(Utilisateur U);
	public void removeUtilisateur(Utilisateur U);
	public void updateUtilisateur(Utilisateur U,String nom_de_compte,String mot_de_passe);
	public Utilisateur getUtilisateur(int id);
	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur getUtilisateurDepuisNom(String nom);

}
