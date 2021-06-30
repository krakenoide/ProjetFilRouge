package com.springmvc.controleurs;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.dao.DataSummaryDao;
import com.springmvc.dao.PlaylistDao;
import com.springmvc.modeles.Playlist;
@Controller
@RequestMapping("/")
public class ControllerPlaylist {
	@Autowired
	DataSummaryDao data;
	@Autowired 
	PlaylistDao playlistdao;
	
	public void initBinder(WebDataBinder wbd) {
		StringTrimmerEditor ste=new StringTrimmerEditor(true); //elimine les espaces
		wbd.registerCustomEditor(String.class, ste); //on transforme les string en ste
	}
	
	@RequestMapping("/ajoutPlayList")
	public String ajoutMorceau(Model m) throws IOException {
		Playlist p=new Playlist();
		data.recup();
		m.addAttribute("dataSummary", data);
		m.addAttribute("modelePlaylist",p);
		
		return "WEB-INF/view/AjoutPlaylist";
	}	
	@RequestMapping("/affichageplaylist")
	public String affichage(@ModelAttribute("modelePlaylist") Playlist p) {
		this.playlistdao.addPlaylist(p);
		return "WEB-INF/view/FenetrePerso";
	}

}
