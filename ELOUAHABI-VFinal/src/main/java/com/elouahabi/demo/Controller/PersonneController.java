package com.elouahabi.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elouahabi.demo.Model.*;
import com.elouahabi.demo.repository.*;

@Controller
public class PersonneController {

	
	@Autowired
	private PersonneRepository pr;

	
	@RequestMapping(value = "/personnes", method = RequestMethod.GET)
	public String index(Model model) {

		List<Personne> pagepersonnes = pr.findAll();
		model.addAttribute("listPersonnes", pagepersonnes);
		return "Personnes";
	}

	
}
