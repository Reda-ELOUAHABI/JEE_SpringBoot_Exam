package com.elouahabi.demo.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Entity
public class Enfant extends Personne {

	public Enfant(Long id, @NotNull String nom, @NotNull String prenom, Boolean marie, Boolean chomeur, Genre genre,
			LocalDate date_de_naissance, Integer age) {
		super(id, nom, prenom, marie, chomeur, genre, date_de_naissance, age);
		// TODO Auto-generated constructor stub
	}

	public Enfant(@NotNull String nom, @NotNull String prenom, Boolean marie, Boolean chomeur, Genre genre,
			LocalDate date_de_naissance, Integer age) {
		super(nom, prenom, marie, chomeur, genre, date_de_naissance, age);
		// TODO Auto-generated constructor stub
	}

	public Enfant() {
		// TODO Auto-generated constructor stub
	}

}
