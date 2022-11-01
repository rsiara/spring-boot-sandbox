package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testable.selenium.pom.SandboxPom;

public class SandboxTestCase {

  WebDriver webDriver;
  SandboxPom sandboxPom;

  @BeforeClass
  public void init(){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\rsiara\\GitHub\\spring-boot-sandbox\\src\\test\\java\\resources\\chromedriver.exe");
    webDriver = new ChromeDriver();
    webDriver.get("http://www.github.com/login");
    sandboxPom = new SandboxPom(webDriver);
  }

  @Test
  public void testLoginPage(){

    sandboxPom.checkSignIn("testUser", "fakePassword");

  }
}
