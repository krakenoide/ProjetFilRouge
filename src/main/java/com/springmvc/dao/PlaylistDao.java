package com.springmvc.dao;

import com.springmvc.modeles.Playlist;

public interface PlaylistDao {
	
	
	public void addPlaylist(Playlist p);
	public void removePlaylist(Playlist p);
	public void updatePlaylist(Playlist p,String titre);
	public Playlist getPlaylist(int id);


}
