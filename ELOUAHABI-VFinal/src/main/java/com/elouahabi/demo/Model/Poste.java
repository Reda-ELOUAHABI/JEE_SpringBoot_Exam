package com.elouahabi.demo.Model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity


public class Poste {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private double salaire;
public void payer() {
	
}

@OneToMany(mappedBy="poste")
private Set<Societe> societes = new HashSet<Societe>();

@OneToMany(mappedBy="poste")
private Set<Personne> personnes = new HashSet<Personne>();




@OneToOne()
@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
private Compte compte;


public Poste(Long id, double salaire) {
	super();
	this.id = id;
	this.salaire = salaire;
}
public Poste() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Poste [id=" + id + ", salaire=" + salaire + "]";
}



}
