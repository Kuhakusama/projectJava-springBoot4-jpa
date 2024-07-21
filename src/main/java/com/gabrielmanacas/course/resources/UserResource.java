package com.gabrielmanacas.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmanacas.course.entities.User;

@RestController //define o webService com o rest
@RequestMapping(value = "/users") //bem auto explicativo, vai buscar somente os users, Caminho do recurso
public class UserResource {
	//endpoitn para acessar users
	//tipo de retorno especifico do spring que retorna responses de requisoções
	@GetMapping //define assim como no nestJS o metodo get so que é mais especifico por isso do mappong de mapear
	public ResponseEntity<User> findAll() {
		User u = new User(1L,"gabriel","gabriel@gmail.com","92999999999","12345");
		return ResponseEntity.ok().body(u); //retorna response com sucesso com o corpo do usuario u
	}
}