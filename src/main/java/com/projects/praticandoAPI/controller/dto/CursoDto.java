package com.projects.praticandoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.praticandoAPI.modelo.Curso;

public class CursoDto {
	private Long id;
	private String nome;
	private float nota;
	private Boolean finalizado;
	
	
	public CursoDto(Curso curso) {
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.nota = curso.getNota();
		this.finalizado = curso.getFinalizado();
	}

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
	
	public static List<CursoDto> converter(List<Curso> cursos) {
		return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
	}
}
