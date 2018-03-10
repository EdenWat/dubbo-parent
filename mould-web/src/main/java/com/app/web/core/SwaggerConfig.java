package com.app.web.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.app.web.controller"})
public class SwaggerConfig implements WebMvcConfigurer {
    private static final String TITLE = "接口说明文档"; // 接口文档说明
    private static final String VERSION = "1.0"; // 接口文档版本

    /**
     * 设置Swagger UI生成的接口目录
     *
     * @return
     */
    @Bean
    public Docket docket() {
        /*
         * 文档分组名 groupName("full")
         */
        return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).apiInfo(apiInfo());
    }

    /**
     * 设置Swagger UI生成的接口文档
     *
     * @return
     */
    private ApiInfo apiInfo() {
        /*
         * 文档描述 description("@2017 Copyrignt. Powered by WangJian.")
         * 文档作者 contact(new Contact("WangJian", "https://github.com/wjtree", "21wjtree@163.com"))
         * 文档协议 licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
         */
        return new ApiInfoBuilder().title(TITLE).version(VERSION).build();
    }

    /**
     * 启用 Swagger UI静态资源访问
     *
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}