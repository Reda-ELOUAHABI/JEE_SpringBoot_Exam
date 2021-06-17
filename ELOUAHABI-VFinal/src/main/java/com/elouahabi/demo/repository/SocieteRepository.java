package com.elouahabi.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.elouahabi.demo.Model.*;

public interface SocieteRepository extends JpaRepository<Societe, Long> {
public List<Societe> findByLiquidites( String a);
}
