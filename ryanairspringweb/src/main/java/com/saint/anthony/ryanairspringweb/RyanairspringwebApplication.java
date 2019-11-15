package com.saint.anthony.ryanairspringweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class RyanairspringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RyanairspringwebApplication.class, args);
	}
}

// ще 6 занять від 21.10.2019 !!!
// Побудова фільтрів через Spring Data JPA
// Буде 4 по фронту, а потім захист з яромиром і ще кимось