package com.projects.praticandoAPI.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToMany
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public Aluno() {
    }
	
	public Aluno(String nome, Curso curso) {
		this.setNome(nome);
		cursos.add(curso);
	}
	
	public Aluno(String nome, List<Curso> cursos) {
		this.setNome(nome);
		this.setCursos(cursos);
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void finalizarCurso(String nomeCurso, float nota) {
		
		int index = 1;
		for (int i = 0; i < this.cursos.size(); i++) {
	        Curso curso = this.cursos.get(i);
	        if (curso.getNome().equals(nomeCurso)) {
	        	index = i;
	        }
	    }
		
		this.cursos.get(index).FinalizarCurso(nota);
	}
	
	public StatusCurso obterCursos(String nomeCursoFinalizado, List<Curso> cursos) {
		int index = -1;
		for (int i = 0; i < this.cursos.size(); i++) {
	        Curso curso = this.cursos.get(i);
	        if (curso.getNome().equals(nomeCursoFinalizado)) {
	        	index = i;
	        }
	    }
		
		if(index == -1)
			return StatusCurso.CURSO_NAO_ENCONTRADO;
		
		Curso cursoFinalizado = this.cursos.get(index);
		
		if(cursoFinalizado.getFinalizado() == false)
			return StatusCurso.EM_PROGRESSO;
		
		else if(cursoFinalizado.getNota() <= 7)
			return StatusCurso.NOTA_BAIXA;
		
		else {
			cursos.addAll(cursos);
			
			return StatusCurso.SUCESSO;	
		}
				
	}
}
