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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="albums")
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //permet d'autoincrémenter les id en mettant des null
	@Column(name="id") //car mon nom de colomne est le meme que mon attribut
	int id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_artiste")
	Artiste artiste;
	@Column(name="nom_album")
	String nomAlbum;
	@Column(name="date_sortie")
	String date_sortie;	
	@Lob
	@Column(name = "couverture", columnDefinition="BLOB")
	private byte [] couverture;

	
	@OneToMany(mappedBy="album",fetch=FetchType.EAGER,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Morceau> morceaux;
	
	public Album(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	public String getNomAlbum() {
		return nomAlbum;
	}

	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}

	public String getDate_sortie() {
		return date_sortie;
	}

	public void setDate_sortie(String date_sortie) {
		this.date_sortie = date_sortie;
	}

	public List<Morceau> getMorceaux() {
		return morceaux;
	}

	public void setMorceaux(List<Morceau> morceaux) {
		this.morceaux = morceaux;
	}

	public byte[] getCouverture() {
		return couverture;
	}

	public void setCouverture(byte[] couverture) {
		this.couverture = couverture;
	}

	
}