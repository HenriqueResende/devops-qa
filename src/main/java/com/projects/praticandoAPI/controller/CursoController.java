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
import com.projects.praticandoAPI.controller.dto.CursoDto;
import com.projects.praticandoAPI.controller.form.CursoForm;
import com.projects.praticandoAPI.modelo.Curso;
import com.projects.praticandoAPI.repository.CursoRepository;

@RestController
@CrossOrigin
@RequestMapping("/Cursos")
public class CursoController {
	
	@Autowired
	private CursoRepository CursoRepository;
	
	@GetMapping
	public List<CursoDto> lista() {
		List<Curso> Cursos = CursoRepository.findAll();
		return CursoDto.converter(Cursos);
	}
	
	@PostMapping
	public ResponseEntity<CursoDto> cadastrar(@RequestBody CursoForm form, UriComponentsBuilder uriBuilder) {
		Curso Curso = form.converter(CursoRepository);
		CursoRepository.save(Curso);
		
		URI uri = uriBuilder.path("/Cursos/{id}").buildAndExpand(Curso.getId()).toUri();
		return ResponseEntity.created(uri).body(new CursoDto(Curso));
	}
}
