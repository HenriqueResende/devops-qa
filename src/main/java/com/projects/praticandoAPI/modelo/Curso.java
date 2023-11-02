package com.projects.praticandoAPI.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private float nota;
	private Boolean finalizado;

	public Curso() {
	}

	public Curso(String nome) {
		setNome(nome);
		setNota(-1);
		setFinalizado(false);
	}

	public Curso(String nome, float nota, Boolean finalizado) {
		setNome(nome);
		setNota(nota);
		setFinalizado(finalizado);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	private void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public float getNota() {
		return nota;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	private void setNota(float nota) {
		this.nota = nota;
	}

	public void FinalizarCurso(float nota) {
		setNota(nota);
		setFinalizado(true);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
