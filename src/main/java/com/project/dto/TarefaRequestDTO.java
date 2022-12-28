package com.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TarefaRequestDTO {

	@NotBlank(message = "O titulo é obrigatorio")
	@Size(min = 3, max = 90, message = "O titulo deverá ter entre 3 e 90 caracteres")
	private String titulo;
	
	@NotBlank(message = "A descrição é obrigatoria")
	@Size(min = 5, max = 200, message = "A descrição deverá ter entre 5 a 200 caracteres")
	private String descricao;
	
	private boolean concluido;
	
	public TarefaRequestDTO(){
	}

	public TarefaRequestDTO(String titulo, String descricao, boolean concluido) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.concluido = concluido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	
}
