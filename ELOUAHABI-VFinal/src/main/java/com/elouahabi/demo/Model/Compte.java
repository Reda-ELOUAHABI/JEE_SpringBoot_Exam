package com.elouahabi.demo.Model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class Compte {
@Id
private Long id;
private double solde;

public  void crediter(double somme) {
	
}
public  void debiter(double somme) {
	
}


//I WANT TO JOIN THEM .. PErsonnes_Compte
//private Set<Personne> personnes = new HashSet<>();




@OneToOne(mappedBy = "compte")
private Poste poste;
public Compte(Long id, double solde) {
	super();
	this.id = id;
	this.solde = solde;
}



//Join Table va etre declare dans une seul entity
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Perso_Comptes", joinColumns = @JoinColumn(name = "id_compte"), // la colonne qui va faire la
																						// jointure
			inverseJoinColumns = @JoinColumn(name = "Id_Personne")//
	)
	private Set<Personne> personnes = new HashSet<>();
public Compte() {
	super();
	// TODO Auto-generated constructor stub
}
public Compte( double solde, Poste poste, Set<Personne> personnes) {
	super();
	
	this.solde = solde;
	this.poste = poste;
	this.personnes = personnes;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public double getSolde() {
	return solde;
}
public void setSolde(double solde) {
	this.solde = solde;
}

}
