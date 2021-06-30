package com.springmvc.controleurs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.nio.file.*;

import com.springmvc.dao.DataSummaryDao;
import com.springmvc.dao.MorceauDao;
import com.springmvc.dao.SonDao;
import com.springmvc.modeles.Morceau;
import com.springmvc.modeles.PathVersRessourcesWeb;
import com.springmvc.modeles.Son;

@Controller
@RequestMapping("/")
public class ControllerLecture {
	@Autowired // injection de dependance qui se fait par l'interface
	MorceauDao morceauDao;
	@Autowired
	SonDao sonDao;
	@Autowired
	DataSummaryDao data;

	@RequestMapping("/lecture")
	public String lecture(Model m,@RequestParam(name="id") int id) throws FileNotFoundException, IOException{
		Morceau mor=morceauDao.get1(id);
		Son son=sonDao.get1(id);
		
		//création d'une mémoire "cache" pour stocker la musique, qu'il faudra remplacer par du javascript
		File pistelecture= new File(PathVersRessourcesWeb.getPath()+"audio/pisteactuelle.mp3");
		Path path = Paths.get(pistelecture.getAbsolutePath());
		Files.write(path, son.getSon());
		m.addAttribute("artiste",mor.getArtiste());
		m.addAttribute("MorceauEnCours",mor);
		m.addAttribute("cheminlecture",pistelecture.getAbsolutePath());
		return "WEB-INF/view/Lecture";
		
	}
	
	@RequestMapping("/finlecture")
	public String finlecture(Model m,@RequestParam(name="cache") String chemin) throws FileNotFoundException, IOException{
		
		//suppression de la mémoire "cache"
		File pistelecture= new File(chemin);
		pistelecture.delete();
		data.recup();
		m.addAttribute("dataSummary",data);
		return "WEB-INF/view/FenetrePerso";
		
	}
}
