package br.com.zupacademy.antoniomatias.casadocodigo.errorhandlers;

import java.util.ArrayList;
import java.util.List;
//2
public class ValidationErrorsOutputDto {

	private List<String> globalErrorMessages = new ArrayList<>();
	private List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();
	
	ValidationErrorsOutputDto() { }
	
	public void addError(String message) {
		//1
		globalErrorMessages.add(message);
	}
	
	public void addFieldError(String field,String message) {
		//1
		FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field,message);
		fieldErrors.add(fieldError);
	}

	public List<String> getGlobalErrorMessages() {
		return globalErrorMessages;
	}

	public List<FieldErrorOutputDto> getFieldErrors() {
		return fieldErrors;
	}
	
	
}
