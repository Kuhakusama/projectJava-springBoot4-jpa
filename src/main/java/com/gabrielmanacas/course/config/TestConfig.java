package com.gabrielmanacas.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabrielmanacas.course.entities.User;
import com.gabrielmanacas.course.repositories.UserRepository;
//serve literlamente para configuração do perfil de teste

@Configuration
@Profile("test") //define o perfil 
public class TestConfig implements CommandLineRunner{
	
	@Autowired //assim que faz classes depednerem de outras classes
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
	
}
