package com.gmail.alexey375890.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String BEARER_AUTH = "Bearer";

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gmail.alexey375890.controller"))
//                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails())
                .securitySchemes(securitySchemes())
                .securityContexts(List.of(securityContext()));
    }

    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("The task-tracker")
                .description("This is API for task-tracker")
                .version("1.0.0")
                .contact(new Contact("Artamonov Alexey",
                        "https://vk.com/javaboss",
                        "alexey375890@gmail.com"))
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        return List.of(new ApiKey(BEARER_AUTH, "Authorization", "header"));
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(bearerAuthReference())
                .build();
    }

    private List<SecurityReference> bearerAuthReference() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference(BEARER_AUTH, authorizationScopes));
    }

}
