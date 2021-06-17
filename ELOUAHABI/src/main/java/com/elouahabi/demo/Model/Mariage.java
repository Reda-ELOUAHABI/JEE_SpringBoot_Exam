package com.elouahabi.demo.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Mariage {
@Id
private Long id;
@NotNull
private LocalDate date;

//A completer ! , ca marche pas , et je vais inverser les annotaions 
//TO DO : les constructeurs de chaque class vont changer , pour creer les objet en differentes profondeurs
@OneToOne
private Personne personneMari;

@OneToOne
private Personne personneFemme;


}
