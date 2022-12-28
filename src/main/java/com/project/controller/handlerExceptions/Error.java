package com.project.controller.handlerExceptions;

import java.time.Instant;

public class Error {

	private Instant horario;
	private int status;
	private String error;
	private String mensagem;
	private String path;
	
	public Error() {
	}

	public Error(Instant horario, int status, String error, String mensagem, String path) {
		this.horario = horario;
		this.status = status;
		this.error = error;
		this.mensagem = mensagem;
		this.path = path;
	}

	public Instant getHorario() {
		return horario;
	}

	public void setHorario(Instant horario) {
		this.horario = horario;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
