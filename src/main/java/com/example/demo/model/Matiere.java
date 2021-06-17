package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	// https://www.objectdb.com/java/jpa/entity/generated
	@NotNull
	private String nom;
	@NotNull
	private int VolumeHoraire;
	@NotNull
	private int semestre;
	
	
	//
	//
//	 MANY TO MANY
	//
	//
	
	
	// Join Table va etre declare dans une seul entity
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Profs_Matieres", joinColumns = @JoinColumn(name = "id_matiere"), // la colonne qui va faire la
																						// jointure
			inverseJoinColumns = @JoinColumn(name = "Id_Professeur")//
	)
	private Set<Professeur> professeurs = new HashSet<>();

}
