package com.project.controller.handlerExceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.exceptions.NotFoundObjException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

	@ExceptionHandler(value = NotFoundObjException.class)
	public ResponseEntity<Error> notFound(NotFoundObjException ex, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Error error = new Error(Instant.now(), status.value(), status.name(), ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
		
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorValidation> errorValidation(MethodArgumentNotValidException ex, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ErrorValidation errorValidation = new ErrorValidation();
		
		errorValidation.setHorario(Instant.now());
		errorValidation.setStatus(status.value());
		errorValidation.setError(status.name());
		errorValidation.setMensagem("Erro ao preencher formulário!");
		errorValidation.setPath(request.getRequestURI());
		
		for(FieldError e : ex.getFieldErrors()) {
			FieldsErrors error = new FieldsErrors(e.getField(), e.getDefaultMessage());
			errorValidation.addErros(error);
		}
		
		return ResponseEntity.status(status).body(errorValidation);
	}
	
	
}
