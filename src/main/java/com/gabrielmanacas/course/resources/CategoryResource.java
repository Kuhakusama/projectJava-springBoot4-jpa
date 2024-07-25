package com.gabrielmanacas.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmanacas.course.entities.Category;
import com.gabrielmanacas.course.services.CategoryServices;

@RestController //define o webService com o rest
@RequestMapping(value = "/categorys") //bem auto explicativo, vai buscar somente os Categorys, Caminho do recurso
public class CategoryResource {
	//camada de controller
	@Autowired
	private CategoryServices service;
	//endpoitn para acessar Categorys
	//tipo de retorno especifico do spring que retorna responses de requisoções
	@GetMapping //define assim como no nestJS o metodo get so que é mais especifico por isso do mappong de mapear
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();		
		return ResponseEntity.ok().body(list); //retorna response com sucesso com o corpo do usuario u
	}
	
	@GetMapping(value = "/{id}") //passando o parametro como id
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}