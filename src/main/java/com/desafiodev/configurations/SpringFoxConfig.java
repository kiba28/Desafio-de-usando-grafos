package com.desafiodev.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.desafiodev")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API Para o desafio dev Milenio Capital").description(
				"API que para cadatro de rotas entre cidades, sendo possivel calcular todas as rotas possíveis, ou apenas a de menor distancia.")
				.license("No licence").licenseUrl("")
				.contact(new Contact("Layrton", "https://www.linkedin.com/in/kiba28/", "123layrton@gmail.com")).build();
	}

}