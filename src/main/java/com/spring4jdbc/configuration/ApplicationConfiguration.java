package com.spring4jdbc.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class ApplicationConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource datasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        ds.setUsername(environment.getRequiredProperty("jdbc.username"));
        ds.setPassword(environment.getRequiredProperty("jdbc.password"));
        ds.setUrl(environment.getRequiredProperty("jdbc.url"));

        return ds;

    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds){
        JdbcTemplate jt =  new JdbcTemplate(ds);
        jt.setResultsMapCaseInsensitive(true);
        return jt;
    }
}
