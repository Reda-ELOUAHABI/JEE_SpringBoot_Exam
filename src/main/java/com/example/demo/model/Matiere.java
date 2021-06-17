package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy="matiere")
    private List<Note> notes =new ArrayList<>(); //pour qu'il soit un objet null lors des rappelles 

	
	

	public Matiere() {
		super();
	}

	public Matiere(String nom, int volumeHoraire, int semestre) {
		super();
		this.nom = nom;
		this.VolumeHoraire = volumeHoraire;
		this.semestre = semestre;
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

	public Set<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(Set<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	public int sizeProfesseur() {
		return professeurs.size();
	}

	public boolean containsProfesseur(Object o) {
		return professeurs.contains(o);
	}

	public boolean addProfesseur(Professeur e) {
		return professeurs.add(e);
	}

	public boolean removeProfesseur(Object o) {
		return professeurs.remove(o);
	}

	public int getVolumeHoraire() {
		return VolumeHoraire;
	}

	public void setVolumeHoraire(int volumeHoraire) {
		this.VolumeHoraire = volumeHoraire;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int sizeNote() {
		return notes.size();
	}

	public boolean containsNote(Object o) {
		return notes.contains(o);
	}

	public boolean addNote(Note e) {
		return notes.add(e);
	}

	public boolean removeNote(Object o) {
		return notes.remove(o);
	}

	public Note getNote(int index) {
		return notes.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matiere other = (Matiere) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", volumeHoraire=" + VolumeHoraire + ", semestre=" + semestre
				+ ", professeurs=" + professeurs + "]";
	}
}
