package com.cloud.CloudDemo.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * 
 * @ClassName: SwaggerConfig
 * @Description: swagger-ui配置
 * @author scy
 * @date 2017年11月8日 上午11:04:32
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public SecurityScheme apiKey() {
		return new ApiKey("access_token", "accessToken", "header");
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(not(regex("/error.*"))).build().pathMapping("/")
				.directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class).apiInfo(demoapiInfo());
	}

	private ApiInfo demoapiInfo() {
		return new ApiInfoBuilder().title("Demo swagger descripted API").description("这是一个Swagger描述的demo.")
				.version("2.0").build();
	}

	// 指定swagger 映射到 /swagger-ui.html
	@Bean
	public WebMvcConfigurerAdapter forwardToIndex() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/swagger").setViewName("redirect:/swagger-ui.html");
			}
		};
	}
	
}