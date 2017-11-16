package com.br.contaaazul.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.br.contaaazul.mars.domain.Robo;
import com.br.contaaazul.mars.repository.RoboRepository;

@SpringBootApplication
public class MarsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MarsApplication.class, args);
		RoboRepository repository = (RoboRepository) ctx.getBean("roboRepository");
		repository.save(new Robo());
	}
}
