package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import testable.LoginService;

@Configuration
@ComponentScan
public class TestConfig {

  @Bean
  public LoginService loginService(){
    return new LoginService();
  }

}
