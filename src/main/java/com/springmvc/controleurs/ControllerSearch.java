package com.springmvc.controleurs;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.DataSummaryDao;

@Controller
@RequestMapping("/")
public class ControllerSearch {
	@Autowired
	DataSummaryDao data;
	
	@RequestMapping("/searchMorceau")
	public String researchMorceau(@RequestParam(name="search") String search, Model m) throws IOException {
		data.recupSearchMorceaux(search);
		m.addAttribute("dataSummary", data);
		return "WEB-INF/view/FenetrePerso";
		
	}
	
	@RequestMapping("/searchAlbum")
	public String researchAlbum(@RequestParam(name="search") String search, Model m) throws IOException {
		data.recupSearchAlbums(search);
		m.addAttribute("dataSummary", data);
		
		return "WEB-INF/view/FenetrePerso";
		
	}
	
	@RequestMapping("/searchArtiste")
	public String researchArtiste(@RequestParam(name="search") String search, Model m) throws IOException {
		data.recupSearchArtistes(search);
		m.addAttribute("dataSummary", data);
		
		return "WEB-INF/view/FenetrePerso";
		
	}
}
