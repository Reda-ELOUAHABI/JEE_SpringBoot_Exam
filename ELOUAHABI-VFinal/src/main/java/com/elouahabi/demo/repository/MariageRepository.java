package com.elouahabi.demo.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.elouahabi.demo.Model.*;

public interface MariageRepository extends JpaRepository<Mariage, Long> {
	public List<Mariage> findByDate( LocalDate d);
}
