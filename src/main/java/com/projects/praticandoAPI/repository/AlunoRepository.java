package com.projects.praticandoAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projects.praticandoAPI.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}