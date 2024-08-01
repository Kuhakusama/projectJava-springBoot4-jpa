package com.gabrielmanacas.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmanacas.course.entities.Product;
import com.gabrielmanacas.course.services.ProductServices;

@RestController //define o webService com o rest
@RequestMapping(value = "/products") //bem auto explicativo, vai buscar somente os users, Caminho do recurso
public class ProductResource {
	//camada de controller
	@Autowired
	private ProductServices service;
	//endpoitn para acessar users
	//tipo de retorno especifico do spring que retorna responses de requisoções
	@GetMapping //define assim como no nestJS o metodo get so que é mais especifico por isso do mappong de mapear
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();		
		return ResponseEntity.ok().body(list); //retorna response com sucesso com o corpo do usuario u
	}
	
	@GetMapping(value = "/{id}") //passando o parametro como id
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}