package com.elouahabi.demo.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Entity
public class Parent extends Personne {

	public Parent(Long id, @NotNull String nom, @NotNull String prenom, Boolean marie, Boolean chomeur, Genre genre,
			LocalDate date_de_naissance, Integer age) {
		super(id, nom, prenom, marie, chomeur, genre, date_de_naissance, age);
		// TODO Auto-generated constructor stub
	}

	public Parent(@NotNull String nom, @NotNull String prenom, Boolean marie, Boolean chomeur, Genre genre,
			LocalDate date_de_naissance, Integer age) {
		super(nom, prenom, marie, chomeur, genre, date_de_naissance, age);
		// TODO Auto-generated constructor stub
	}

	public Parent() {
		// TODO Auto-generated constructor stub
	}

}
