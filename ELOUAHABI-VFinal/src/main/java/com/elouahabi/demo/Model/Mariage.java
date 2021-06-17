package com.elouahabi.demo.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Mariage {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotNull
private LocalDate date;

//A completer ! , ca marche pas , et je vais inverser les annotaions 
//TO DO : les constructeurs de chaque class vont changer , pour creer les objet en differentes profondeurs
@OneToOne
private Personne personneMari;

@OneToOne
private Personne personneFemme;

public Mariage( @NotNull LocalDate date, Personne personneMari, Personne personneFemme) {
	super();
	this.date = date;
	this.personneMari = personneMari;
	this.personneFemme = personneFemme;
}
public Mariage() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public Personne getPersonneMari() {
	return personneMari;
}
public void setPersonneMari(Personne personneMari) {
	this.personneMari = personneMari;
}
public Personne getPersonneFemme() {
	return personneFemme;
}
public void setPersonneFemme(Personne personneFemme) {
	this.personneFemme = personneFemme;
}




}
