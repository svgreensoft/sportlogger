package org.sversh.sportlogger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Sergey Vershinin 
 */
@Configuration
public class PropConfig {
    public static final String ENVIR_PROP = "ENVIRONMENT";
    private static final String FILE_NAME = "/properties/sl-%s.properties";

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        String env = System.getProperty(ENVIR_PROP);
        if (env == null) {
            env = System.getenv(ENVIR_PROP);
        }
        String resource = String.format(FILE_NAME, env);
        propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource(resource));
        return propertySourcesPlaceholderConfigurer;
    }

}
