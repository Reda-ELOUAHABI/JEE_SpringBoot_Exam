package com.elouahabi.demo.Model;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;




@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
@NotNull
private String nom ;
@NotNull
private String Prenom;
private Boolean marie;
private Boolean chomeur;
private Genre genre;
private LocalDate date_de_naissance;
private Integer age; 

public double revenu() {
	return 0;
}



@OneToMany(mappedBy="personne")
private Set<Societe> societes = new HashSet<Societe>();

@ManyToOne()
private Poste poste;

//private Set<Personne> enfants = new HashSet<Personne>();

//
//
//Le code de ManyToMany qui ne marche pas malheureusement
//
//

@OneToMany(fetch = FetchType.EAGER,mappedBy="personnes")
private Set<Compte> comptes = new HashSet<>(); //pour qu'il soit un objet null lors des rappelles 


@OneToOne()
@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
private Mariage mariage;

//@OneToOne(mappedBy = "personneFemme")
//private Mariage mariaged_autre;

//@OneToOne
//@JoinColumn(name ="id",referencedColumnName="idMariage")
//private Mariage mariage;



///Two Parent + Many Children
//private List<Enfant> enfants = new ArrayList<Enfant>();
//
//private List<Parent> parents = new ArrayList<Parent>();
//

//
//
//public Personne(Long id, @NotNull String nom, @NotNull String prenom, Boolean marie, Boolean chomeur, Genre genre,
//		LocalDate date_de_naissance, Integer age, Mariage mariage, List<Enfant> enfants, List<Parent> parents) {
//	super();
//	this.id = id;
//	this.nom = nom;
//	Prenom = prenom;
//	this.marie = marie;
//	this.chomeur = chomeur;
//	this.genre = genre;
//	this.date_de_naissance = date_de_naissance;
//	this.age = age;
//	this.mariage = mariage;
//	this.enfants = enfants;
//	this.parents = parents;
//}
public Personne(Long id, @NotNull String nom, @NotNull String prenom, Boolean marie, Boolean chomeur, Genre genre,
		LocalDate date_de_naissance, Integer age) {
	super();
	this.id = id;
	this.nom = nom;
	Prenom = prenom;
	this.marie = marie;
	this.chomeur = chomeur;
	this.genre = genre;
	this.date_de_naissance = date_de_naissance;
	this.age = age;
}
public Personne( @NotNull String nom, @NotNull String prenom, Boolean marie, Boolean chomeur, Genre genre,
		LocalDate date_de_naissance, Integer age) {
	super();
	this.nom = nom;
	Prenom = prenom;
	this.marie = marie;
	this.chomeur = chomeur;
	this.genre = genre;
	this.date_de_naissance = date_de_naissance;
	this.age = age;
}





public Personne() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return Prenom;
}

public void setPrenom(String prenom) {
	Prenom = prenom;
}

public Boolean getMarie() {
	return marie;
}

public void setMarie(Boolean marie) {
	this.marie = marie;
}

public Boolean getChomeur() {
	return chomeur;
}

public void setChomeur(Boolean chomeur) {
	this.chomeur = chomeur;
}

public Genre getGenre() {
	return genre;
}

public void setGenre(Genre genre) {
	this.genre = genre;
}

public LocalDate getDate_de_naissance() {
	return date_de_naissance;
}

public void setDate_de_naissance(LocalDate date_de_naissance) {
	this.date_de_naissance = date_de_naissance;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}



public Set<Societe> getSocietes() {
	return societes;
}
public void setSocietes(Set<Societe> societes) {
	this.societes = societes;
}
public Poste getPoste() {
	return poste;
}
public void setPoste(Poste poste) {
	this.poste = poste;
}
public Set<Compte> getComptes() {
	return comptes;
}
public void setComptes(Set<Compte> comptes) {
	this.comptes = comptes;
}
public Mariage getMariage() {
	return mariage;
}
public void setMariage(Mariage mariage) {
	this.mariage = mariage;
}
//public List<Enfant> getEnfants() {
//	return enfants;
//}
//public void setEnfants(List<Enfant> enfants) {
//	this.enfants = enfants;
//}
//public List<Parent> getParents() {
//	return parents;
//}
//public void setParents(List<Parent> parents) {
//	this.parents = parents;
//}



@Override
public String toString() {
	return "Personne [id=" + id + ", nom=" + nom + ", Prenom=" + Prenom + ", marie=" + marie + ", chomeur=" + chomeur
			+ ", genre=" + genre + ", date_de_naissance=" + date_de_naissance + ", age=" + age + "]";
}






}
