package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Personne;



public interface PersonneRepository extends JpaRepository<Personne, Long>{
	public List<Personne> findByNom(String nom);
	
}
