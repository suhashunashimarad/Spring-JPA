package com.telusko.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.telusko.springmvcboot.model.Alien;

@org.springframework.web.bind.annotation.RestController
/** Mention Rest Controller annotation if you are fetching data in JSON format (@ResponseBody)  */
public class RestController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="aliens", produces= {"application/xml"})			//Produces : Mentions which format to be used in Server code
	/*@ResponseBody*/							/***   @ResponseBody : Sends data in data format not JSP name, No 404 Error 
		     									   Using List method for JSON format in POSTMAN, for TEXT use String method
												   Jackson.jar(inbuilt) is responsible to convert Java data into JSON  */
	public List<Alien> getAliens() {	
		List<Alien> aliens =  repo.findAll();
//		int i = 9/0;
		System.out.println("Fetching aliens");
		return aliens;
	}
	
	@GetMapping("alien/{aid}")										//For one particular aid-->  alien/104
	public Alien getAlien(@PathVariable("aid") int aid) {	
		Alien alien = repo.findById(aid).orElse(new Alien(0,"Not Found"));
		return alien;
	}
											//application/json
	@PostMapping(path="alien",consumes = {MediaType.APPLICATION_JSON_VALUE})									/** we can have same URI with 2 difft methods : GET & POST 
																GET : Fetching Data & POST : Sending data to server */
	public Alien addAlien(@RequestBody Alien alien) {						
		repo.save(alien);
		return alien;
	}
	
	@PutMapping("deleteAlien/{aid}")									/** PUT : For update */
	public void deleteAlien(@PathVariable("aid") int aid) {						
		repo.deleteById(aid);
	}
	
}
