package com.lady.lady.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableOpenApi
@EnableSwagger2WebMvc
public class Knife4jConfig {


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("大小姐轰炸接口文档")
                .description("大小姐出品")
                .termsOfServiceUrl("http://127.0.0.1:8051/")
                .contact(new Contact("大小姐", "http://127.0.0.1:8051/", "v_chaiyapeng@baidu.com"))
                .version("v1.0")
                .build();
    }

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lady.lady"))
                .paths(PathSelectors.any())
                .build();
    }
}
