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
import com.projects.praticandoAPI.controller.form.AlunoForm;
import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.repository.AlunoRepository;
import com.projects.praticandoAPI.repository.CursoRepository;

@RestController
@CrossOrigin
@RequestMapping("/Aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository AlunoRepository;
	
	@Autowired
	private CursoRepository CursoRepository;
	
	@GetMapping
	public List<AlunoDto> lista() {
		List<Aluno> Aluno = AlunoRepository.findAll();
		return AlunoDto.converter(Aluno);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder) {
		Aluno Aluno = form.converter(AlunoRepository, CursoRepository);
		AlunoRepository.save(Aluno);
		
		URI uri = uriBuilder.path("/Aluno/{id}").buildAndExpand(Aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDto(Aluno));
	}
}
