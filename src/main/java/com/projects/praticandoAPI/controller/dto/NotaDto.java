package com.projects.praticandoAPI.controller.dto;

public class NotaDto {
	private String NomeCurso;
	private float Nota;
	
	public String getNomeCurso() {
		return NomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		NomeCurso = nomeCurso;
	}
	public float getNota() {
		return Nota;
	}
	public void setNota(float nota) {
		Nota = nota;
	}
}
