package com.springmvc.services;

import java.util.List;

import com.springmvc.modeles.Album;
import com.springmvc.modeles.Artiste;
import com.springmvc.modeles.Genre;
import com.springmvc.modeles.Morceau;

public interface IServices {
	public List<Morceau> getMorceaux();
	public List<Artiste> getArtistes();
	public List<Album> getAlbums();
	public List<Genre> getGenres();

}
