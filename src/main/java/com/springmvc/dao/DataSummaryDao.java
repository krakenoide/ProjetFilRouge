package com.springmvc.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.springmvc.modeles.Album;
import com.springmvc.modeles.Artiste;
import com.springmvc.modeles.Genre;
import com.springmvc.modeles.Morceau;

public interface DataSummaryDao {
	public void recup() throws IOException;
	public void recupSearchMorceaux(String search) throws IOException;
	public void recupSearchArtistes(String search) throws IOException;
	public void recupSearchAlbums(String search) throws IOException;
	public void delete() throws IOException;
	public List<Artiste> getListeArtistes();
	public void setListeArtistes(List<Artiste> listeArtistes);
	public List<Genre> getListeGenres();
	public void setListeGenres(List<Genre> listeGenres);
	public List<Morceau> getListeMorceaux();
	public void setListeMorceaux(List<Morceau> listeMorceaux);
	public List<Album> getListeAlbums();
	public void setListeAlbums(List<Album> listeAlbums);
}
