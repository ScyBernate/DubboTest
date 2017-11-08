package com.cloud.CloudDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.cloud.CloudDemo.controller")
public class SwaggerConfig {

	@Bean
	public SecurityScheme apiKey() {
		return new ApiKey("access_token", "accessToken", "header");
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select().build()
				.directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class).apiInfo(demoapiInfo());
	}

	private ApiInfo demoapiInfo() {
		return new ApiInfoBuilder().title("Demo swagger descripted API").description("这是一个Swagger描述的demo.")
				.version("2.0").build();
	}
}