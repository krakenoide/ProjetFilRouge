package com.springmvc.modeles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="artistes")
public class Artiste {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id") 
	private int id;
	
	@Column(name="nom")
	private String nomArtiste;
	
	@Lob
	@Column(name = "photo", columnDefinition="BLOB")
	private byte [] photoArtiste;

	
	@OneToMany(mappedBy="artiste",fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Album> albums;
	
	@OneToMany(mappedBy="artiste",fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Morceau> morceaux;
	
	public Artiste(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Morceau> getMorceaux() {
		return morceaux;
	}

	public void setMorceaux(List<Morceau> morceaux) {
		this.morceaux = morceaux;
	}

	public byte[] getPhotoArtiste() {
		return photoArtiste;
	}

	public void setPhotoArtiste(byte[] photoArtiste) {
		this.photoArtiste = photoArtiste;
	}

		
	public String toString() {
		return nomArtiste;
	}

	

}