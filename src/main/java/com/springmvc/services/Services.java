package com.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.DataSummaryDao;
import com.springmvc.modeles.Album;
import com.springmvc.modeles.Artiste;
import com.springmvc.modeles.Genre;
import com.springmvc.modeles.Morceau;

@Service
public class Services implements IServices{
	@Autowired
	private DataSummaryDao data;
	
	@Transactional
	public List<Morceau> getMorceaux(){
		return data.getListeMorceaux();
	}
	@Transactional
	public List<Artiste> getArtistes(){
		return data.getListeArtistes();
	}
	@Transactional
	public List<Album> getAlbums(){
		return data.getListeAlbums();
	}
	@Transactional
	public List<Genre> getGenres(){
		return data.getListeGenres();
	}
}
