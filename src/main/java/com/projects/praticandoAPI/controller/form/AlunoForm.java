package com.projects.praticandoAPI.controller.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.modelo.Curso;
import com.projects.praticandoAPI.repository.AlunoRepository;
import com.projects.praticandoAPI.repository.CursoRepository;

public class AlunoForm {
	private String nome;
	private List<String> cursos = new ArrayList<String>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}
	
	public Aluno converter(AlunoRepository AlunoRepository, CursoRepository cursoRepository) {
		List<Curso> listCursos = new ArrayList<Curso>();
		for(int i = 0; i < cursos.size(); i++) {
			listCursos.add(cursoRepository.findByNome(this.cursos.get(i)));
		}
		return new Aluno(nome, listCursos);
	}
}
