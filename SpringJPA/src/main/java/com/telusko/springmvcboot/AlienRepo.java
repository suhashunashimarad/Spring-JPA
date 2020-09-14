package com.telusko.springmvcboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telusko.springmvcboot.model.Alien;

//JpaRepository is Interface which gives methods like findAll
//DAO methods 

public interface AlienRepo extends JpaRepository<Alien, Integer>{

	List<Alien> findByAnameOrderByAidDesc(String aname);			//Query DSL (Domain Specific Language)
																	//Protocol : should start with findBy followed by caps
	
	
	@Query("from Alien where aname= :name")				//placeholder
	List<Alien> find(@Param("name") String aname);
}
