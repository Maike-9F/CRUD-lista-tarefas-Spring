package com.project.controller.handlerExceptions;

import java.util.ArrayList;
import java.util.List;

public class ErrorValidation extends Error{

	private List<FieldsErrors> errors = new ArrayList<>();

	public ErrorValidation() {
	}

	public ErrorValidation(List<FieldsErrors> errors) {
		this.errors = errors;
	}

	public List<FieldsErrors> getErrors() {
		return errors;
	}

	public void addErros(FieldsErrors fieldsErrors) {
		errors.add(fieldsErrors);
	}
	
	
}
