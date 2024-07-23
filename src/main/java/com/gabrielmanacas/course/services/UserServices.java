package com.gabrielmanacas.course.services;

import java.util.List;

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
}
