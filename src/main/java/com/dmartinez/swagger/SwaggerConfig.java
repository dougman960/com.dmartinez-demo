package com.dmartinez.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(getApiInfo())
        		.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dmartinez"))
                .build();
    }
	
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");

	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Service Search offers by stores",
				"Service API Description",
				"0.0.2",
				"Copyright © 2024 DM",
				new Contact("Douglas Martinez", "https://www.linkedin.com/in/douglas-alexander-mart%C3%ADnez-loor-02756515a/", "dougman960@gmail.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
	
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();

	}
	
	private List<SecurityReference> defaultAuth(){
		 AuthorizationScope authorizationScope =  new AuthorizationScope("global","accesEverything");
		 AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		 authorizationScopes[0] = authorizationScope;
		 return Arrays.asList(new SecurityReference("JWT",authorizationScopes));
	}
	
	
}
