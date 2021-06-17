package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.*;
import com.example.demo.repository.*;



@Controller
public class ProfesseurController {

	@Autowired
	private ProfesseurRepository prr;

	@Autowired
	private CompteRepository cr;

	@RequestMapping(value = "/professeurs", method = RequestMethod.GET)
	public String index(Model model) {

		List<Professeur> pageprofesseurs = prr.findAll();
		model.addAttribute("listProfesseurs", pageprofesseurs);
		return "Professeurs";
	}

	@RequestMapping(value = "/chercherProfesseur")
	public String Chercher(Model model, @RequestParam(name = "nomProfesseur", defaultValue = "") String nom) {

		List<Professeur> pageProfesseurs;
		if (nom.length() == 0)
			pageProfesseurs = prr.findAll();
		else
			pageProfesseurs = prr.findByNom(nom);
		model.addAttribute("listProfesseurs", pageProfesseurs);

		return "Professeurs";
	}

	@RequestMapping(value = "/ajouterprofesseur", method = RequestMethod.GET)
	public String ajouterNote(Model model) {
		return "ajouterprofesseur";
	}

	@RequestMapping(value = "/ajouterprofesseur", method = RequestMethod.POST)
	public String ajouterNote(Model model, Long matricule, String nom, String prenom, String datenaissance,
			int numSomme, GradeType grade, String email, @RequestParam(name="password" , defaultValue = "1234") String password) {
		System.out.println(matricule);
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(datenaissance);
		System.out.println(numSomme);
		System.out.println(grade);
		System.out.println(email);
		System.out.println(password);
		if (matricule != 0L && nom != "" && prenom != "" && numSomme != 0 && email != "" && password != "") {
			Professeur prof = new Professeur(matricule, nom, prenom, LocalDate.parse(datenaissance), numSomme, grade);
			prr.save(prof);
			Compte co = new Compte(nom, prenom, prof);
			cr.save(co);
			return "redirect:/professeurs";
		} else {
			model.addAttribute("matricule", matricule);
			model.addAttribute("nom", nom);
			model.addAttribute("prenom", prenom);
			model.addAttribute("datenaissance", datenaissance);
			model.addAttribute("numSomme", numSomme);
			model.addAttribute("grade", grade);
			model.addAttribute("email", email);
			model.addAttribute("password", password);
			return "ajouterprofesseur";
		}

	}

}
