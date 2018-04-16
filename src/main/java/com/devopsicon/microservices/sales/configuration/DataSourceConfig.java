package com.devopsicon.microservices.sales.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Profile("!test")
@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource devDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("JDBC_DRIVER_CLASS_NAME"));
        dataSource.setUrl(env.getRequiredProperty("JDBC_URL"));
        dataSource.setUsername(env.getRequiredProperty("JDBC_USERNAME"));
        dataSource.setPassword(env.getRequiredProperty("JDBC_PASSWORD"));
        return dataSource;
    }
}
