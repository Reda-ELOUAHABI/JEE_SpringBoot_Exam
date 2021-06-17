package com.elouahabi.demo.Model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity


public class Societe {
@Id
private Long id;
private double liquidites ;

@ManyToOne()
private Personne personne;
@ManyToOne()
private Poste poste;
public Societe(Long id, double liquidites) {
	super();
	this.id = id;
	this.liquidites = liquidites;
}

public Societe() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Societe [id=" + id + ", liquidites=" + liquidites + "]";
}

}
