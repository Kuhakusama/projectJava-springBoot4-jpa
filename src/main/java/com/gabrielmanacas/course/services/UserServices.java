package com.gabrielmanacas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanacas.course.entities.User;
import com.gabrielmanacas.course.repositories.UserRepository;
import com.gabrielmanacas.course.services.exceptions.ResourceNotFoundExceptions;

@Service //decorador para definir um service na camada de services
public class UserServices {
	
	@Autowired //faz a injençaõ de dependecias
	private UserRepository repository; //define a variavel que manipula o bacno de dados ou seja a tablea
	
	public List<User> findAll() { //Metodo, camada se serviço
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //retorna um Optional com tipo User
		return obj.orElseThrow(() -> new ResourceNotFoundExceptions(id)); //retorna somente o objeto User
		//como no netsj as chamadas vão retornar uma entidade com diversos atributos, o campo User possui as informações desejadas
	}
	
	public User insert(User obj) { //inserção de objetos tipo user
		return repository.save(obj);
	}
	
	public void delete(Long id) { //os tipos são em caizxa alta, assim como as classes, ja o resto começo com letra padrão
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj); //função para atualizar as entidades. 
		return repository.save(entity); //ertorna para o banco de dados os dados  atualizados. 
	}

	private void updateData(User entity, User obj) { // void pq não necessita retornar nada para o banco de dados, ache internamente dentro no codigo
		//assim como sua referencia
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
