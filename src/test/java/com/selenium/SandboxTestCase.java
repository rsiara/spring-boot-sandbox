package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testable.selenium.MyWebDriver;
import testable.selenium.pom.SandboxPom;

import java.util.logging.Level;

public class SandboxTestCase {

  WebDriver webDriver;
  SandboxPom sandboxPom;

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
