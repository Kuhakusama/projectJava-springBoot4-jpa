package com.gabrielmanacas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanacas.course.entities.Category;
import com.gabrielmanacas.course.repositories.CategoryRepository;

@Service //decorador para definir um service na camada de services
public class CategoryServices {
	
	@Autowired //faz a injençaõ de dependecias
	private CategoryRepository repository; //define a variavel que manipula o bacno de dados ou seja a tablea
	
	public List<Category> findAll() { //Metodo, camada se serviço
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id); //retorna um Optional com tipo Category
		return obj.get(); //retorna somente o objeto Category
		//como no netsj as chamadas vão retornar uma entidade com diversos atributos, o campo Category possui as informações desejadas
	}
}
