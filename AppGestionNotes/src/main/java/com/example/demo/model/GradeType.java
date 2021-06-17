package com.example.demo.model;

public enum GradeType {
	PA("Professeur Assistant"), PH("Professeur Habilite"), PES("Professeur d'Enseignement Superieur");

	private String description;

	private GradeType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}


}
