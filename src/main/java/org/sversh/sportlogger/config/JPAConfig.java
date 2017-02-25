package org.sversh.sportlogger.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.sversh.sportlogger.model.domain.DomainPackage;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

/**
 * @author Sergey Vershinin
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {DomainPackage.class})
@ComponentScan
public class JPAConfig {

    @Value("${jdbc.driverClass}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String userID;

    @Value("${jdbc.password}")
    private String password;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    
    @Value("${hibernate.schema.name}")
    private String schemaName;

    @Resource
    private Environment env;

    @Bean(name = "entityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPackagesToScan("org.sversh.sportlogger");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public DataSource getDataSource() {
//        PoolConfiguration props = new PoolProperties();
//
//        props.setDataSource(getDataSourceTemplate());
//        props.setInitialSize(10);
//        props.setInitSQL("SELECT 1");
//        props.setMinIdle(10);
//        props.setMaxIdle(100);
//        props.setMaxActive(100);
//        props.setMaxWait(30000);
//        props.setJmxEnabled(true);
//        props.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
//        props.setRemoveAbandoned(true);
//        props.setRemoveAbandonedTimeout(3600);
//        props.setLogAbandoned(true);
//        props.setTestOnBorrow(true);
//        props.setUseEquals(false);
//        props.setFairQueue(false);
//        props.setTimeBetweenEvictionRunsMillis(30000);
//        props.setMinEvictableIdleTimeMillis(30000);
//        props.setValidationQuery("SELECT 1");
//        props.setValidationInterval(300000);

        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setDatabaseName(schemaName);
        dataSource.setUser(userID);
        dataSource.setPassword(password);
        Properties props = new Properties();
        dataSource.initializeProperties(props);
        dataSource.setURL(url);
        return dataSource ;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        System.out.println("hibernate dialect: " + dialect.toString());
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.put("hibernate.cache.use_second_level_cache", "false");
        //properties.put("net.sf.ehcache.configurationResourceName", "META-INF/persistence-ehcache.xml");

        return properties;
    }

    @Bean
    public DriverManagerDataSource getDataSourceTemplate() {
        DriverManagerDataSource dataSourceTemplate = new DriverManagerDataSource(url, userID, password);
        dataSourceTemplate.setDriverClassName(driver);
        return dataSourceTemplate;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

}
