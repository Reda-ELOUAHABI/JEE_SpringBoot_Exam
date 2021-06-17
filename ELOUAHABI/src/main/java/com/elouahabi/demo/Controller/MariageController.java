package com.elouahabi.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elouahabi.demo.Model.Mariage;
import com.elouahabi.demo.repository.MariageRepository;


@Controller
public class MariageController {
	@Autowired
	MariageRepository mr;
	
	@RequestMapping(value = "/mariages", method = RequestMethod.GET)
	public String listmariage(Model model )
	{
		List<Mariage> listmariage=mr.findAll();
		model.addAttribute("listmariage",listmariage);
		return "mariage";
	}

}


