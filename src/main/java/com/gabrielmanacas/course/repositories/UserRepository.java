package com.gabrielmanacas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielmanacas.course.entities.User;

//o Jpa vai fazer a injection dos dados no bacno de dados
//vão ser interfaces
public interface UserRepository extends JpaRepository<User, Long> { //framework do proprio spring
	
}
