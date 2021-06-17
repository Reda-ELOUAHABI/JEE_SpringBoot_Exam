package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Student extends Personne {
	@NotNull
	private Long niveau = 2L;
	@NotNull
	private boolean AnneeReserve;
	
	 @OneToMany(mappedBy="student")
	    private List<Note> notes =new ArrayList<>(); //pour qu'il soit un objet null lors des rappelles 


	public Student() {
		super();
	}

	public Student(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance) {
		super(matricule, nom, prenom, date_naissance);
	}

	public Student(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance,
			@NotNull Long niveau, @NotNull boolean anneeReserve) {
		super(matricule, nom, prenom, date_naissance);
		this.niveau = niveau;
		AnneeReserve = anneeReserve;
	}

	@Override
	public String toString() {
		return "Student [niveau=" + niveau + ", AnneeReserve=" + AnneeReserve + ", toString()=" + super.toString()
				+ "]";
	}

	public Long getNiveau() {
		return niveau;
	}

	public void setNiveau(Long niveau) {
		this.niveau = niveau;
	}

	public boolean isAnneeReserve() {
		return AnneeReserve;
	}

	public void setAnneeReserve(boolean anneeReserve) {
		AnneeReserve = anneeReserve;
	}
	

}
