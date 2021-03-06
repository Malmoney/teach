package com.liurq.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestServerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("teacher无纸化办公","teacher无纸化办公","1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liurq.modules.files.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("teacher无纸化办公");
    }

    private ApiInfo apiInfo(String name, String description, String version) {
        return new ApiInfoBuilder()
                .title(name)
                .description(description)
                .termsOfServiceUrl("")
                //.contact(contact)
                .version(version)
                .build();
    }

}
