package com.selenium;

import com.example.demo.DemoApplication;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testable.LoginService;
import testable.model.User;
import testable.selenium.MyWebDriver;
import testable.selenium.pom.SandboxPom;

import java.util.logging.Level;

@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = DemoApplication.class)
public class SandboxTestCase {

  WebDriver webDriver;
  SandboxPom sandboxPom;

  @Autowired
  LoginService loginService;

  @BeforeClass
  public void init(){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\rsiara\\GitHub\\spring-boot-sandbox\\src\\test\\java\\resources\\chromedriver.exe");
    webDriver = new MyWebDriver();
    webDriver.get("http://www.github.com");

    sandboxPom = new SandboxPom(webDriver);
  }

  @AfterTest
  public void clear(){
    webDriver.quit();
  }

  @Test
  public void testSignInManual(){
    loginService.logIn(new User("bob", "password"));
    sandboxPom.checkSignInButtonManual();
  }

  @Test
  public void testSignFindBy(){
    sandboxPom.checkSignInButtonFindBy();
  }

  @Test
  public void testSignFindByAndWait(){
    sandboxPom.checkSignInButtonFindByAndWait();
  }
}
