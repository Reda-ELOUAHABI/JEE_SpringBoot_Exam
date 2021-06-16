package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Professeur extends Personne {
	
	// @Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
	@NotNull
	private int numSomme;
	
	@Enumerated(EnumType.STRING)
	private GradeType grade = GradeType.PA;
//	
	private int indice = 500;
	public Professeur(@NotNull int numSomme,  int indice) {
		super();
		this.numSomme = numSomme;
		this.indice = indice;
	}
	
	public Professeur(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance,
			@NotNull int numSomme) {
		super(matricule, nom, prenom, date_naissance);
		this.numSomme = 500;
	}
	
	public Professeur(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance,
			@NotNull int numSomme, GradeType gradeType) {
		super(matricule, nom, prenom, date_naissance);
		this.numSomme = 500;
		this.grade=gradeType;
	}
	
	
	public Professeur(@NotNull int numSomme) {
		super();
		this.numSomme = numSomme;
		this.indice=500;
	}
	public Professeur() {
		super();
	}

	@Override
	public String toString() {
		return "Professeur [numSomme=" + numSomme + ", indice=" + indice +" **\nGrade "+grade+ ", getPrenom()=" + getPrenom()
				+ ", getDate_naissance()=" + getDate_naissance() + ", getMatricule()=" + getMatricule() + ", getNom()="
				+ getNom() + ", toString()=" + super.toString() +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + indice;
		result = prime * result + numSomme;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professeur other = (Professeur) obj;
		if (indice != other.indice)
			return false;
		if (numSomme != other.numSomme)
			return false;
		return true;
	}
	
}
