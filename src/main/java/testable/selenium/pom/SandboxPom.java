package testable.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SandboxPom {

  WebDriver driver;

  //Constructor that will be automatically called as soon as the object of the class is created
  public SandboxPom(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(className = "HeaderMenu-link--sign-in")
  private WebElement signInButton;

  @FindBy(name = "q")
  private WebElement searchBox;


  public void checkSignInButtonManual(){
    WebElement signInButtonManual = driver.findElement(By.className("HeaderMenu-link--sign-in"));
    System.out.println(signInButtonManual.getText().toUpperCase());
    searchBox.sendKeys("madonna");
    searchBox.sendKeys(Keys.ENTER);
    System.out.println(signInButtonManual.getText().toUpperCase());
  }

  public void checkSignInButtonFindBy(){
    System.out.println(signInButton.getText().toUpperCase());
    searchBox.sendKeys("madonna");
    searchBox.sendKeys(Keys.ENTER);
    System.out.println(signInButton.getText().toUpperCase());
  }

  public void checkSignInButtonFindByAndWait(){
    System.out.println(signInButton);
    System.out.println(signInButton.getText().toUpperCase());
//    searchBox.sendKeys("madonna");
//    searchBox.sendKeys(Keys.ENTER);
//    System.out.println(signInButton.getText().toUpperCase());
    waitUntilElementIsVisible(signInButton);
  }

  public void waitUntilElementIsVisible(WebElement element){
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    webDriverWait.until(ExpectedConditions.visibilityOf(element));
  }


}
