package com.project.dto;

import java.time.Instant;

public class TarefaResponseDTO {

	private Long id;
	private String titulo;
	private String descricao;
	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Instant dataCriacao;
	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Instant dataAtualizacao;
	
	private boolean concluido;
	
	public TarefaResponseDTO() {
	}

	public TarefaResponseDTO(Long id, String titulo, String descricao, Instant dataCriacao, Instant dataAtualizacao, boolean concluido) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
		this.concluido = concluido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Instant getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Instant getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Instant dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	
}
