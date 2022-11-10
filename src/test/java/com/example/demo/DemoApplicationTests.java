package com.example.demo;

import com.example.demo.config.TestConfig;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import testable.LoginService;
import testable.model.User;


@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = DemoApplication.class)
class DemoApplicationTests {

	@Autowired
	LoginService loginService;

	@Autowired
	PersonServiceImpl personService;

	@Test
	void contextLoads() {
		loginService.logIn(new User("madonna", "password"));
	}

}
