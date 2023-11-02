package com.projects.praticandoAPI.modelo;

public enum StatusCurso {
	SUCESSO(1),
	EM_PROGRESSO(2),
	NOTA_BAIXA(3),
	CURSO_NAO_ENCONTRADO(4);

	private final int valor;
	private StatusCurso(int valorOpcao) {
		valor = valorOpcao;
	}
	
	public int getValor() {
		return valor;
	}
}
