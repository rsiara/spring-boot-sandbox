package com.example.demo.connfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

//    Spring boot tworzy własną datasource ale dla celów ćwiczeniowych tworzę własna, nadpisuje
//    utworzoną  przez Spribng boot. Bez tej klasy też działa na domyślnej DS

    @Bean(name = "myDataSource")
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }

    @Bean(name = "namedJdbcABC")
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(@Qualifier("myDataSource")DataSource myDataSource) {
        return new NamedParameterJdbcTemplate(myDataSource);
    }
}
