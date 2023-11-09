package com.projects.praticandoAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.projects.praticandoAPI.controller.dto.AlunoDto;
import com.projects.praticandoAPI.controller.dto.NotaDto;
import com.projects.praticandoAPI.controller.form.AlunoForm;
import com.projects.praticandoAPI.controller.form.NotaForm;
import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.modelo.Curso;
import com.projects.praticandoAPI.repository.AlunoRepository;
import com.projects.praticandoAPI.repository.CursoRepository;

@RestController
@CrossOrigin
@RequestMapping("/Nota")
public class NotaController {
	@Autowired
	private CursoRepository CursoRepository;
	
	@GetMapping
	public NotaDto lista(String nomeCurso) {
		NotaDto nota = new NotaDto();
		
		nota.setNomeCurso(nomeCurso);
		nota.setNota(CursoRepository.findByNome(nomeCurso).getNota());
		
		return nota;
	}
	
	@PostMapping
	public ResponseEntity<Curso> cadastrar(@RequestBody NotaForm form, UriComponentsBuilder uriBuilder) {
		Curso curso = CursoRepository.findByNome(form.getNomeCurso());
		curso.setNota(form.getNota());
		CursoRepository.save(curso);
		
		URI uri = uriBuilder.path("/Nota/{id}").buildAndExpand(form.getNomeCurso()).toUri();
		return ResponseEntity.created(uri).body(curso);
	}
}
