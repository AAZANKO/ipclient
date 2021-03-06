package com.aip.dao.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("com.aip.dao")
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
// @Import({DatabaseConfiguration.class},{ServiceConfiguration.class},{WebConfiguration.class})
// import Cofigure Class web -> service -> dao(Hibernate)
public class ApplicationConfigurationDao {

    @Bean
    // @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DataSource dataSource(@Value("${db.url}") String url,
                                 @Value("${db.user}") String username,
                                 @Value("${db.password}") String password,
                                 @Value("${db.driver}") String driverName) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverName);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource, Properties hibernateProperties) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.aip.dao");
        factoryBean.setHibernateProperties(hibernateProperties);
        return factoryBean;
    }

    @Bean
    public Properties hibernateProperties(@Value("classpath:hibernate.properties") Resource databaseResource) throws IOException {
        Properties properties = new Properties();
        properties.load(databaseResource.getInputStream());
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}