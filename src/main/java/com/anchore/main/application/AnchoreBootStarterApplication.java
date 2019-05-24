/*
 * @Author Rk.Nayak
 * MAY/24/2019
 * 
 */
package com.anchore.main.application;

import java.util.Arrays;

import javax.persistence.Entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {
		                                   "com.anchore.endpoint", "com.anchore.helper",
		                                   "com.anchore.service","com.anchore.pojo"
		                                   })
@EnableWebMvc
@EntityScan(basePackages = {"com.anchore.model"})
public class AnchoreBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnchoreBootStarterApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	    return args -> {

	        System.out.println("Let's inspect the beans provided by Spring Boot:\n");

	        String[] beanNames = ctx.getBeanDefinitionNames();
	        Arrays.sort(beanNames);
	        for (String beanName : beanNames) {
	            System.out.println(beanName);
	        }

	        System.out.println("--End OF  BEAN Scopes---");
	    };

 }
}
