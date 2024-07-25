package com.gabrielmanacas.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabrielmanacas.course.entities.Category;
import com.gabrielmanacas.course.entities.Order;
import com.gabrielmanacas.course.entities.User;
import com.gabrielmanacas.course.entities.enums.OrderStatus;
import com.gabrielmanacas.course.repositories.CategoryRepository;
import com.gabrielmanacas.course.repositories.OrderRepository;
import com.gabrielmanacas.course.repositories.UserRepository;
//serve literlamente para configuração do perfil de teste

@Configuration
@Profile("test") //define o perfil 
public class TestConfig implements CommandLineRunner{
	
	@Autowired //assim que faz classes depednerem de outras classes
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID,u1); //instancia a data/momento que o objeto foi criado
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WATING_PAYMENT,u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.PAID,u1);
		//null = chave; Instant = instante em Iso; u1 = é o instaciamento do user do peido como deito no resource do order
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
	
	
}
