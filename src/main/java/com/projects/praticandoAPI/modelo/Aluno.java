package com.projects.praticandoAPI.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Aluno {
	private String Nome;
	private List<Curso> Cursos = new ArrayList<Curso>();;
	
	public Aluno(String nome, Curso curso) {
		Nome = nome;
		Cursos.add(curso);
	}
	
	public void finalizarCurso(String nomeCurso, float nota) {
		
		int index = 1;
		for (int i = 0; i < this.Cursos.size(); i++) {
	        Curso curso = this.Cursos.get(i);
	        if (curso.getNome().equals(nomeCurso)) {
	        	index = i;
	        }
	    }
		
		this.Cursos.get(index).FinalizarCurso(nota);
	}
	
	public StatusCurso obterCursos(String nomeCursoFinalizado, List<Curso> cursos) {
		int index = -1;
		for (int i = 0; i < this.Cursos.size(); i++) {
	        Curso curso = this.Cursos.get(i);
	        if (curso.getNome().equals(nomeCursoFinalizado)) {
	        	index = i;
	        }
	    }
		
		if(index == -1)
			return StatusCurso.CURSO_NAO_ENCONTRADO;
		
		Curso cursoFinalizado = this.Cursos.get(index);
		
		if(cursoFinalizado.getFinalizado() == false)
			return StatusCurso.EM_PROGRESSO;
		
		else if(cursoFinalizado.getNota() <= 7)
			return StatusCurso.NOTA_BAIXA;
		
		else {
			Cursos.addAll(cursos);
			
			return StatusCurso.SUCESSO;	
		}
				
	}
}
