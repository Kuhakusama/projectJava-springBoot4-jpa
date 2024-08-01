package com.gabrielmanacas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanacas.course.entities.Product;
import com.gabrielmanacas.course.repositories.ProductRepository;

@Service //decorador para definir um service na camada de services
public class ProductServices {
	
	@Autowired //faz a injençaõ de dependecias
	private ProductRepository repository; //define a variavel que manipula o bacno de dados ou seja a tablea
	
	public List<Product> findAll() { //Metodo, camada se serviço
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id); //retorna um Optional com tipo Product
		return obj.get(); //retorna somente o objeto Product
		//como no netsj as chamadas vão retornar uma entidade com diversos atributos, o campo Product possui as informações desejadas
	}
}
