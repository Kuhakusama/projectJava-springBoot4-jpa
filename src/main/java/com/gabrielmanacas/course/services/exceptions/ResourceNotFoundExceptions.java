package com.gabrielmanacas.course.services.exceptions;

//subclasse do runTime exceptions do proprio java
public class ResourceNotFoundExceptions extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExceptions(Object id) {
		super("Resource not found. id"+id);
	}
	
}
