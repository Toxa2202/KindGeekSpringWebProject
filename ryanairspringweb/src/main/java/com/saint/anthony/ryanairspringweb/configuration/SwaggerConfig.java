package com.saint.anthony.ryanairspringweb.configuration;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.saint.anthony.ryanairspringweb.controller")
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SpringBoot-Swagger-API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.saint.anthony.ryanairspringweb.controller"))
                .build()
                .apiInfo(metaData())
                .consumes(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE));
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Ryanair Spring Project for KindGeek School")
                .description("\"REST API \"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Anthony Saint", "http://test.com", "svyatoj@gmail.com"))
                .build();
    }
}
