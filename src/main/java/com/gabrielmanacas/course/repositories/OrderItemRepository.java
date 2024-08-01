package com.gabrielmanacas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielmanacas.course.entities.OrderItem;
import com.gabrielmanacas.course.entities.pk.OrderItemPk;

//o Jpa vai fazer a injection dos dados no bacno de dados
//vão ser interfaces
//Eu poderia fazer @Repository mas ja esta heradadno o repository do Jpa
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> { //framework do proprio spring
	
}
