package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Note {

	@Id 
    private int id;
    @NotNull
	@ManyToOne
    private Student student;
   
    @NotNull
   	@ManyToOne
       private Matiere matiere;
}
