package com.gabrielmanacas.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value = "/{id}") //passando o parametro como id
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//o path é definido pela camniho /users/id, pois o id é padrão e o que o componete vai pegar/aparecer e o user/id
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")//precisa referenciar qual o id do user para ser deletado
	public ResponseEntity<Void> delete(@PathVariable Long id){ //sem retorn = void
		service.delete(id);
		return ResponseEntity.noContent().build(); //garantir que a aplicação volte a rodar, pois a função não possui algo para retornar.(Lembrar da teoria async e await/ try e catch)
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){ //ResquestBody é necesasrio pois pega as inforações enviadas na requisição para fazer a operção
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj); //isso equivale a um tratamente de erro if()else() return no JS
	}
	
}