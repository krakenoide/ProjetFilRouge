package com.springmvc.modeles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="playlist")
public class Playlist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="titre")
	String titre;
	//@ManytoMany()
	///List <Morceau> lmorceau;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "createur")
	Utilisateur createur;
	@Transient
	String genre;
	
	
	public Playlist() {
		
	}
	
//	public void removemorceau(Morceau m) {
//		this.lmorceau.remove(m);
//	}
//	
//	public void addmorceau(Morceau m) {
//		this.lmorceau.add(m);
//	}
//	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

//	public List<Morceau> getLmorceau() {
//		return lmorceau;
//	}
//	public void setLmorceau(List<Morceau> lmorceau) {
//		this.lmorceau = lmorceau;
//	}
	public Utilisateur getCreateur() {
		return createur;
	}
	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
	
	
	
	
	
	
	
	
	
	
	

}
