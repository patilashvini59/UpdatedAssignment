package com.example.Assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TeacherException {
	@ExceptionHandler(value = TeacherE.class)
	public ResponseEntity<Object> teacheExceptionMethod(TeacherE teacher) {
		  return new ResponseEntity<>("Teacher Already Exist",HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = StudentExcp.class)
	public ResponseEntity<Object> methodExceptionMethod(StudentExcp student) {
		return new ResponseEntity<>("Student Already Exist",HttpStatus.CONFLICT);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}

}
