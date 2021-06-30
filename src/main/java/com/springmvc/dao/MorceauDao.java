package com.springmvc.dao;

import com.springmvc.modeles.Morceau;

public interface MorceauDao {
	public Morceau get1(int id);
	public void ajout1(Morceau m);
	public void supp1(Morceau m);
	public void update1(Morceau m);

}
