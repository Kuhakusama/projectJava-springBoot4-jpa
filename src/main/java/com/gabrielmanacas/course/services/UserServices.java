package com.gabrielmanacas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanacas.course.entities.User;
import com.gabrielmanacas.course.repositories.UserRepository;

@Service //decorador para definir um service na camada de services
public class UserServices {
	
	@Autowired //faz a injençaõ de dependecias
	private UserRepository repository; //define a variavel que manipula o bacno de dados ou seja a tablea
	
	public List<User> findAll() { //Metodo, camada se serviço
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //retorna um Optional com tipo User
		return obj.get(); //retorna somente o objeto User
		//como no netsj as chamadas vão retornar uma entidade com diversos atributos, o campo User possui as informações desejadas
	}
}
