package com.springmvc.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.modeles.Album;
import com.springmvc.modeles.Artiste;
import com.springmvc.modeles.Genre;
import com.springmvc.modeles.Morceau;
import com.springmvc.services.IServices;

@RestController
@RequestMapping("/api") //preciser qu'on est dans l'api
public class ControllerRest {
	@Autowired
	private IServices serv;
	
	@GetMapping("/morceaux")
	public List<Morceau> getMorceaux(){
		return serv.getMorceaux();
	}
	
	@GetMapping("/artistes")
	public List<Artiste> getArtistes(){
		return serv.getArtistes();
	}
	
	@GetMapping("/albums")
	public List<Album> getAlbums(){
		return serv.getAlbums();
	}
	
	@GetMapping("/genres")
	public List<Genre> getGenres(){
		return serv.getGenres();
	}
	
	
}
