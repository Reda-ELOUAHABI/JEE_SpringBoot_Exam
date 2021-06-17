package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Matiere;
import com.example.demo.model.Note;
import com.example.demo.model.Student;

public interface NoteRepository extends JpaRepository<Note, Long>{
	 Page<Note> findByStudent(Student student , Pageable pageable);
	 Page<Note> findByMatiere(Matiere matiere, Pageable pageable);
	 Page<Note> findByStudentAndMatiere(Student student,Matiere matiere,Pageable pageable);

}
