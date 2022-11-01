package testable.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SandboxPom {

  WebDriver driver;

  //Constructor that will be automatically called as soon as the object of the class is created
  public SandboxPom(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(name = "login")
  private WebElement usernameField;

  @FindBy(name = "password")
  private WebElement passwordField;

  @FindBy(name = "commit")
  private WebElement signInButton;

  @FindBy(id = "js-flash-container")
  private WebElement warning;

  public void checkSignIn(String username, String password){
    usernameField.sendKeys(username);
    passwordField.sendKeys(password);
    signInButton.click();

  }


}
