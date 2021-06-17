package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Compte {
//	public Compte(String string, String string2, Professeur prof) {
//		// TODO Auto-generated constructor stub
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@NotNull
	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
	@javax.validation.constraints.Email
	@Column(unique = true)
	private String email;
	@NotNull
	private String password;
	@NotNull
	private Boolean active;
	
	@OneToOne(mappedBy = "compte")
	private Personne personne;
	
}
