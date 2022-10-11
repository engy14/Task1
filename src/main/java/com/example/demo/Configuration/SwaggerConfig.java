package com.example.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
//	         .apiInfo(metaInfo());
	   }

//	private ApiInfo metaInfo() {
//		ApiInfo apiInfo=new ApiInfo(
//				"Telegraph Swagger",
//				"Telegraph Project Documentation",
//				"1.0",
//				"Terms Of Services",
//				new Contact("MTS","www.google.com search","mts@gmail.com"),
//				"License",
//				"www.google.com search"				
//				);
//		return apiInfo;
//
//	}
}
