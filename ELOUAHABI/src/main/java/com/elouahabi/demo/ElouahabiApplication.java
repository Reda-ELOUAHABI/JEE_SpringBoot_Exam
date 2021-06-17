package com.elouahabi.demo;

import java.time.LocalDate;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.elouahabi.demo.Model.*;
import com.elouahabi.demo.Model.Personne;
import com.elouahabi.demo.Model.Societe;
import com.elouahabi.demo.repository.CompteRepository;
import com.elouahabi.demo.repository.PersonneRepository;
import com.elouahabi.demo.repository.SocieteRepository;

@SpringBootApplication
public class ElouahabiApplication {
@Autowired
PersonneRepository pr;
@Autowired
SocieteRepository sr;
@Autowired
CompteRepository cr;

	public static void main(String[] args) {
		SpringApplication.run(ElouahabiApplication.class, args);
	}
	@SuppressWarnings("resource")
	@Bean
 public CommandLineRunner console() {
		return args -> {
		System.out.println("Start*****\n\n");
		
		Personne p = new Personne(1L, "EL OUAHaABI", "Rda", true, true, null, LocalDate.of(1998, 6, 21), 23);
		pr.save(p);
		System.out.println(pr.findAll());
		
		 Compte c=new Compte(1L,20);
		cr.save(c);
		System.out.println(cr.findAll());
		
		Societe s=new Societe(1L,20);
		sr.save(s);
		System.out.println(sr.findAll());
		
		System.out.println("\n\nEnd**********");
		new Scanner(System.in).next();
	};
 }}

