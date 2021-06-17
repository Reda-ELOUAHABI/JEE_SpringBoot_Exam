package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Professeur;
import com.example.demo.repository.ProfesseurRepository;

@Controller
@RequestMapping(value="/professeurs")
public class ProfesseurController {
 @Autowired
 ProfesseurRepository pr;
 
 @RequestMapping(value="list", method = RequestMethod.GET) 
 //GET c'est la methode par default
 //list sans slash => deja dans le pere
 public String index(Model m) {
	 List<Professeur> lp=pr.findAll();
	 m.addAttribute("ListProfesseurs",lp);//ListProffesseurs=dico cle value
	return "professeurs";
	 
 }
}
