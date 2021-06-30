package com.springmvc.controleurs;


import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.*;
import com.springmvc.modeles.*;


@Controller
@RequestMapping("/")
public class ControllerMorceau {
	@Autowired //injection de dependance qui se fait par l'interface
	MorceauDao morceauDao;
	@Autowired
	DataSummaryDao data;
	@Autowired
	ArtisteDao artisteDao;
	@Autowired
	AlbumDao albumDao;
	
	@InitBinder //pour eliminer les string vide et les assigner à type null
	public void initBinder(WebDataBinder wbd) {
		StringTrimmerEditor ste=new StringTrimmerEditor(true); //elimine les espaces
		wbd.registerCustomEditor(String.class, ste); //on transforme les string en ste
	}
	
	@RequestMapping("/HomePage")
	public String premieraffichage(Model m) throws IOException {
		return "WEB-INF/view/FenetrePrincipale";
	}
	
	@RequestMapping("/Login")
	public String login(Model m) throws IOException {
		data.recup();
		m.addAttribute("dataSummary", data);
		return "WEB-INF/view/FenetrePerso";
	}
	
	/*
	@RequestMapping("/Logout")
	public String logout(Model m) throws IOException {
		data.delete();
		return "WEB-INF/view/FenetrePrincipale";
	}
	*/
	
	@RequestMapping("/affichageAjout")
	public String ajoutMorceau(Model m) throws IOException {
		Morceau nouveau=new Morceau();
		data.recup();
		m.addAttribute("dataSummary", data);
		m.addAttribute("modelMorceau",nouveau);
		return "WEB-INF/view/AjoutMorceau";
	}
	
	//pour que cela fonctionne il faut utiliser les formulaires de spring et mettre une ligne en plus dans les jsp
	@RequestMapping("/affichageResultatMorceau")
	public String affichageMorceau(@Valid @ModelAttribute("modelMorceau") Morceau mor, BindingResult resultat,Model m) throws IOException {
		
		if (resultat.hasErrors()) {
			return "WEB-INF/view/AjoutMorceau";
		}
		else {
			mor=mor.finaliserMorceau(data);
			morceauDao.ajout1(mor);
			data.recup();
			
			m.addAttribute("dataSummary", data);
							
			return "WEB-INF/view/FenetrePerso";
		}
	}
	
	@RequestMapping("/suppression")
	public String suppressionMorceau(Model m,@RequestParam(name="id") int id) throws IOException {
		Morceau mor=new Morceau();
		mor.setId(id);
		morceauDao.supp1(mor);
		data.recup();
		m.addAttribute("dataSummary", data);
		return "WEB-INF/view/FenetrePerso";
	}
	
	@RequestMapping("/modification")
    public String prepareModificationMorceau(Model m,@RequestParam(name="id") int id) throws IOException {
        Morceau mor = morceauDao.get1(id);
        System.out.println(mor.getId());
        mor.setNomAlbum(mor.getAlbum().getNomAlbum());
        mor.setNomArtiste(mor.getArtiste().getNomArtiste());
        mor.setNomGenreMorceau(mor.getGenre().getNomGenre());
        data.recup();
        m.addAttribute("dataSummary", data);
        m.addAttribute("modelMorceau",mor);
        m.addAttribute("morceauID",mor.getId());
        return "WEB-INF/view/ModificationMorceau";
    }
	
	@RequestMapping("/vaModifierMorceau")
    public String modifieMorceau(@Valid @ModelAttribute("modelMorceau") Morceau mor, BindingResult resultat,Model m,@RequestParam(name="id") int id) throws IOException {
        if (resultat.hasErrors()) {
            data.recup();
            m.addAttribute("dataSummary", data);
            m.addAttribute("modelMorceau",mor);
            m.addAttribute("morceauID",id);
            return "WEB-INF/view/ModificationMorceau";
        }else {
            Morceau morceauAModifier = morceauDao.get1(id);
            System.out.println(mor.getId()+" "+morceauAModifier.getId());
            morceauAModifier.updateMorceau(mor,data);
            System.out.println(mor.getId()+" "+morceauAModifier.getId());
            morceauDao.update1(morceauAModifier);
            data.recup();
            m.addAttribute("dataSummary", data);
            return "WEB-INF/view/FenetrePerso";
        }
    }
	
	@RequestMapping("/artistevue")
    public String vueartiste(Model m,@RequestParam(name="id") int id) throws IOException {
        Artiste art = artisteDao.get1(id);
        data.recup();
        m.addAttribute("dataSummary", data);
        m.addAttribute("Artiste",art);
        return "WEB-INF/view/VueArtiste";
    }
	
	@RequestMapping("/albumvue")
    public String vuealbum(Model m,@RequestParam(name="id") int id) throws IOException {
        Album alb = albumDao.get1(id);
        data.recup();
        m.addAttribute("dataSummary", data);
        m.addAttribute("Album",alb);
        return "WEB-INF/view/VueAlbum";
    }
	
}
