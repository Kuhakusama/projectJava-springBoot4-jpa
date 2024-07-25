package com.gabrielmanacas.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmanacas.course.entities.Order;
import com.gabrielmanacas.course.services.OrderServices;

@RestController //define o webService com o rest
@RequestMapping(value = "/orders") //bem auto explicativo, vai buscar somente os Orders, Caminho do recurso
public class OrderResource {
	//camada de controller
	@Autowired
	private OrderServices service;
	//endpoitn para acessar Orders
	//tipo de retorno especifico do spring que retorna responses de requisoções
	@GetMapping //define assim como no nestJS o metodo get so que é mais especifico por isso do mappong de mapear
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();		
		return ResponseEntity.ok().body(list); //retorna response com sucesso com o corpo do usuario u
	}
	
	@GetMapping(value = "/{id}") //passando o parametro como id
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}