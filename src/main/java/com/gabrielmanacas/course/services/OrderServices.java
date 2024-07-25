package com.gabrielmanacas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanacas.course.entities.Order;
import com.gabrielmanacas.course.repositories.OrderRepository;

@Service //decorador para definir um service na camada de services
public class OrderServices {
	
	@Autowired //faz a injençaõ de dependecias
	private OrderRepository repository; //define a variavel que manipula o bacno de dados ou seja a tablea
	
	public List<Order> findAll() { //Metodo, camada se serviço
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id); //retorna um Optional com tipo User
		return obj.get(); //retorna somente o objeto User
		//como no netsj as chamadas vão retornar uma entidade com diversos atributos, o campo User possui as informações desejadas
	}
}
