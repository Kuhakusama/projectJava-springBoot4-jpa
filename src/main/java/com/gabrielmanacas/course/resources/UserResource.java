package com.gabrielmanacas.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmanacas.course.entities.User;
import com.gabrielmanacas.course.services.UserServices;

@RestController //define o webService com o rest
@RequestMapping(value = "/users") //bem auto explicativo, vai buscar somente os users, Caminho do recurso
public class UserResource {
	//camada de controller
	@Autowired
	private UserServices service;
	//endpoitn para acessar users
	//tipo de retorno especifico do spring que retorna responses de requisoções
	@GetMapping //define assim como no nestJS o metodo get so que é mais especifico por isso do mappong de mapear
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();		
		return ResponseEntity.ok().body(list); //retorna response com sucesso com o corpo do usuario u
	}
}