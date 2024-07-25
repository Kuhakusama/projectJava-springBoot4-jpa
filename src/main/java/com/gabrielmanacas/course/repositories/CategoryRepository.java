package com.gabrielmanacas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielmanacas.course.entities.Category;

//o Jpa vai fazer a injection dos dados no bacno de dados
//vão ser interfaces
//Eu poderia fazer @Repository mas ja esta heradadno o repository do Jpa
public interface CategoryRepository extends JpaRepository<Category, Long> { //framework do proprio spring
	
}
