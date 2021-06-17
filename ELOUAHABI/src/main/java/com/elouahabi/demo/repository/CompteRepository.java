package com.elouahabi.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.elouahabi.demo.Model.*;

public interface CompteRepository extends JpaRepository<Compte, Long> {
public List<Compte> findBySolde( String a);
}
