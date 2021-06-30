package com.springmvc.dao;

import com.springmvc.modeles.Genre;

public interface GenreDao {
	public Genre get1(int id);
	public void ajout1(Genre g);
	public void supp1(Genre g);
}
