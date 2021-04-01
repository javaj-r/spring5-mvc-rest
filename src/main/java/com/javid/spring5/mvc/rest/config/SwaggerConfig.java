package com.javid.spring5.mvc.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by Javid on 3/30/2021.
 */

@EnableSwagger2
@EnableOpenApi
@Configuration
public class SwaggerConfig /*extends WebMvcConfigurationSupport*/ {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("Version 1 Documentation")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        var contact = new Contact("Javid", "https://github.com/javaj-r", "javid.rafiee@gmail.com");

        return new ApiInfo(
                "Spring 5 MVC Rest"
                , "Spring 5 MVC Restfull api example"
                , "0.0.1-SNAPSHOT"
                , "To be learning example"
                , contact
                , "Apache License Version 2.0"
                , "https://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList<>()
        );
    }

/**
 *
 @Override protected void addResourceHandlers(ResourceHandlerRegistry registry) {
 registry.addResourceHandler("swagger-ui.htm")
 .addResourceLocations("classpath:/META-INF/resources/");

 registry.addResourceHandler("/webjars/**")
 .addResourceLocations("classpath:/META-INF/resources/webjars/");
 }
 */

}
