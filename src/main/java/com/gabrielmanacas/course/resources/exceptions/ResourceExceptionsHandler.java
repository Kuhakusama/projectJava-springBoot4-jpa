package com.gabrielmanacas.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gabrielmanacas.course.services.exceptions.ResourceNotFoundExceptions;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //intercepta as exceçoões para realizxar os tratamenteos
public class ResourceExceptionsHandler {
	
	//pode ser qualquer nomde mas sempre se lembre do codigo limpo
	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundExceptions e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(),error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
