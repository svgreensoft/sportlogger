package org.sversh.sportlogger.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * @author Sergey Vershinin 
 */
@Configuration
@Import({JPAConfig.class, PropConfig.class})
/*
 * We want explicitly import configurations
 */
@ComponentScan(basePackages = "org.sversh.sportlogger",
               excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
               pattern = "org.sversh.sportlogger.config.*"))
public class RootContextConfig {

}
