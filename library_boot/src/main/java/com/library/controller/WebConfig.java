package com.library.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*@Configuration标注在类上，相当于把该类作为spring的xml配置文件中的<beans>
	作用为：配置spring容器(应用上下文)|定义配置类
@EnableWebMvc是使用Java 注解快捷配置Spring Webmvc的一个注解
	在使用该注解后配置一个继承于WebMvcConfigurerAdapter的配置类即可配置好Spring Webmvc
@Controller，@Service，@Repository注解，查看其源码你会发现
	他们中有一个共同的注解@Component
	没错@ComponentScan注解默认就会
	装配标识了@Controller，@Service，@Repository，@Component注解的类
	到spring容器中
*/
@Configuration
@EnableWebMvc
@ComponentScan("com.library.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	//千万别忘记这个注释
    @Bean
    public ViewResolver viewResolver() {
    	//内部资源视图解析器,将视图解析为Web应用的内部资源,一般是JSP
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/static/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");
    }
}