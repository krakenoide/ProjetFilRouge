package com.springmvc.controleurs;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.UtilisateurDao;
import com.springmvc.modeles.Utilisateur;

@Controller
public class ControllerUtilisateur {

	@Autowired
	UtilisateurDao uilisateurDao;
		
	@RequestMapping("/vaVersJSPCreationNouvelUtilisateur")
	public String preparationNouvelUtilisateur(Model m) throws IOException {

		String s = null;
		Utilisateur newUtilisateur = new Utilisateur();
		m.addAttribute("modelUtilisateur", newUtilisateur);
		m.addAttribute("errorUtilisateur", s);
		m.addAttribute("errorMDP", s);

		return "WEB-INF/view/NouvelUtilisateur";
	}

	@RequestMapping("/enregisterNouvelUtilisateur")
	public String enregisterNouvelUtilisateur(Model m, @Valid @ModelAttribute("modelUtilisateur") Utilisateur u,
			BindingResult resultat) throws IOException {
		String s = null;
		if (resultat.hasErrors()) {
			return "WEB-INF/view/NouvelUtilisateur";
		} else {
			Utilisateur udb = this.uilisateurDao.getUtilisateurDepuisNom(u.getNomDeCompte());
			if (udb == null) {
				if (u.getMotDePasse().equals(u.getMotDePasseVerification())) {
					String BCryptedPwrd = BCrypt.hashpw(u.getMotDePasse(), BCrypt.gensalt());
					System.out.println(u.getMotDePasse()+" | "+BCryptedPwrd);
					u.setMotDePasse("{bcrypt}"+BCryptedPwrd);
					this.uilisateurDao.addUtilisateur(u);
					return "WEB-INF/view/Login";
				} else {
					m.addAttribute("errorUtilisateur", s);
					m.addAttribute("errorMDP", "Les mots de passe ne correspondent pas");
					return "WEB-INF/view/NouvelUtilisateur";
				}
			} else {
				m.addAttribute("errorUtilisateur", "Nom d'utilisateur deja existant");
				m.addAttribute("errorMDP", s);
				return "WEB-INF/view/NouvelUtilisateur";
			}
		}
	}

	@RequestMapping("/vaVersJSPLogin")
	public String preparationLogin(Model m) throws IOException {
		return "WEB-INF/view/Login";
	}

	@RequestMapping("/accesRefuse")
	public String affichageAccesRefuse(){
		return "WEB-INF/view/AccessDenied";
	}
	
}



