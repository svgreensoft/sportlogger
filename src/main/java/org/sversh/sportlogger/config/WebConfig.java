package org.sversh.sportlogger.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Sergey Vershinin
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sversh.sportlogger.web.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
}
