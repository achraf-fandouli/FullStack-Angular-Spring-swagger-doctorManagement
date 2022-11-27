package com.jee.cabinetSpring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> not_found(ResourceNotFound ex) {
		Responce res = new Responce(ex.getMessage());
		return ResponseEntity.ok().body(res);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> not_found(Exception ex) {
		return ResponseEntity.internalServerError().body("Internal server Error");
	}
}
