package com.example.demo;

import java.time.LocalDate;

import java.util.Scanner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.GradeType;
import com.example.demo.model.Personne;
import com.example.demo.model.Professeur;
import com.example.demo.model.Student;
import com.example.demo.repository.CompteRepository;
import com.example.demo.repository.MatiereRepository;
import com.example.demo.repository.PersonneRepository;
import com.example.demo.repository.ProfesseurRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class ApplicationProfApplication {
	@Autowired
	PersonneRepository pr;

	@Autowired
	ProfesseurRepository prr;
	
	@Autowired
	StudentRepository st;
	
	@Autowired
	MatiereRepository mt;
	
	@Autowired
	CompteRepository cp;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationProfApplication.class, args);
	}

		
	
	
	@SuppressWarnings("resource")
	@Bean
	public CommandLineRunner console() {
		return args -> {
			System.out.println("-----------Execution du programme------------");
			 
			Personne p = new Personne(12345L, "Kj", "M************m", LocalDate.of(2000, 1, 1));
			pr.save(p);
//			System.out.println(pr.findByNom("Kabbaj"));
			System.out.println(pr.findAll());
			Professeur pro = new Professeur(34567L, "Belouadha", "Fatime-Zahra", LocalDate.of(2000, 1, 1),10 ,GradeType.PES);
			prr.save(pro);
			System.out.println(prr.findAll());
			
			Student st1= new Student(45678L, "El OUAHABI", "Reda", LocalDate.of(2000, 8 ,1),19L,false);
			st.save(st1);
			System.out.println(st.findAll());
			System.out.println("-----------Fin Execution du programme------------");
			new Scanner(System.in).next();
		};
	}
	
	}
