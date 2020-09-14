package com.telusko.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.springmvcboot.model.Alien;

@Controller
public class HomeController {

	@Autowired
	AlienRepo repo;

	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Aliens");
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("getAliens")
	public String getAliens(Model m) {
		m.addAttribute("result", repo.findAll());
		return "showAliens";

	}

	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid, Model m) {
		m.addAttribute("result", repo.getOne(aid));
		return "showAliens";
	}
	
	@GetMapping("getAlienByName")
	public String getAlienByName(@RequestParam String aname, Model m) {
//		m.addAttribute("result", repo.findByAnameOrderByAidDesc(aname));			//Query DSL
		m.addAttribute("result", repo.find(aname));									//Query Annotation
		return "showAliens";
	}

	@PostMapping(value = "addAlien")
	public String addAlien(@ModelAttribute Alien a) {
		repo.save(a);
		return "result";
	}
	
}
