package com.elouahabi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elouahabi.demo.Model.*;

public interface PosteRepository extends JpaRepository<Poste, Long> {
public List<Poste> findBySalaire( String a);
}
