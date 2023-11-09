package com.projects.praticandoAPI.controller.form;
import com.projects.praticandoAPI.modelo.Curso;
import com.projects.praticandoAPI.repository.CursoRepository;

public class CursoForm {
	private Long id;
	private String nome;
	private float nota;
	private Boolean finalizado;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public float getNota() {
		return nota;
	}
	
	public Curso converter(CursoRepository cursoRepository) {	
		return new Curso(nome, nota, finalizado);
	}
}
