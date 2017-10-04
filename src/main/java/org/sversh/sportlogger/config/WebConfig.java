package org.sversh.sportlogger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

/**
 * Sergey Vershinin
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sversh.sportlogger.web.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver resourceBundleViewResolver() {
	    ResourceBundleViewResolver bean = new ResourceBundleViewResolver();
	    bean.setBasename("views");
	    return bean;
	}
}
