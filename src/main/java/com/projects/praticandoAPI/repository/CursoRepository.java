package com.projects.praticandoAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projects.praticandoAPI.controller.dto.CursoDto;
import com.projects.praticandoAPI.controller.form.CursoForm;
import com.projects.praticandoAPI.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}