package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
	List<Professeur> findByNom(String nom);
    Page<Professeur> findByNom(String nom, Pageable pageable);
	//it's the same , but with hql , we could costumise what we want
	@Query("select p from Professeur p where p.nom like :x")
	public Page<Professeur> findProfesseurByNom(@Param("x") String nom, Pageable pageable);

	
}
