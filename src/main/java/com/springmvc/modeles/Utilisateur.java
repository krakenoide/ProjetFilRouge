package com.springmvc.modeles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class Utilisateur {
	@Id
	@NotNull(message ="*") //if we try to make a Contact without giving it a new name i'll send an error
	@Pattern(regexp="[A-Za-z0-9 /]{0,40}",message="Veuillez ne pas utiliser de caracteres speciaux !")
	@Column(name="username")
	String nomDeCompte;
	@NotNull(message ="*") //if we try to make a Contact without giving it a new name i'll send an error
	@Size(min=5,message="Votre Mot de Passe doit contenir 5 caracteres au minimum !")
	@Column(name="password")
	String motDePasse; 
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Role> roles;
	
	@OneToMany(mappedBy="createur", cascade= {CascadeType.ALL})
	List <Playlist> playlists;
	@Transient
	String nom;



	@Transient
	String prenom;
	@Transient
	String motDePasseVerification;
	
	public Utilisateur() {
	}

	
	public String getNomDeCompte() {
		return nomDeCompte;
	}


	public void setNomDeCompte(String nomDeCompte) {
		this.nomDeCompte = nomDeCompte;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMotDePasseVerification() {
		return motDePasseVerification;
	}


	public void setMotDePasseVerification(String motDePasseVerification) {
		this.motDePasseVerification = motDePasseVerification;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	


//	public void createplaylist(String t) {
//		// TODO Auto-generated method stub
//		Playlist p = new Playlist();
//		p.setCreateur(this);
//		this.playlists.add(p);
//	}


//	public void addtoplaylist(Playlist p,Morceau m) {
//		// TODO Auto-generated method stub
//		p.addmorceau(m);
//	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}


	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}


	public void addmymusic() {
		// TODO Auto-generated method stub
		
	}

}
