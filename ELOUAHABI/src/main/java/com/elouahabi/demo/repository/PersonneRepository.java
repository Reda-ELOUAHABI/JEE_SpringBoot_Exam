package com.elouahabi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elouahabi.demo.Model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
public List<Personne> findByNom( String a);

}
