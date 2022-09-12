package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

// Klasa nadpisuje dataSource i jdbcTemplate tworzony przez spring boot starter

//    @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:testdb");
//        dataSourceBuilder.username("sa");
//        dataSourceBuilder.password("password");
//        return dataSourceBuilder.build();
//    }
//
//    @Bean(name = "namedJdbcTemplate")
//    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(@Qualifier("dataSource")DataSource myDataSource) {
//        return new NamedParameterJdbcTemplate(myDataSource);
//    }
}
