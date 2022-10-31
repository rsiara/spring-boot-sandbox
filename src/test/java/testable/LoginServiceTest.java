package testable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners(TestListener.class)
public class LoginServiceTest {

  @Test(priority = 0, groups = {"all_os"})
  public void test() throws InterruptedException {
    System.out.println("test: " + Thread.currentThread().getId());
  }

  @Test(priority = 0, groups = {"all_os", "windows_os"}, retryAnalyzer = RetryService.class)
  public void win_test() throws InterruptedException {
    System.out.println("win test");
    Assert.assertTrue(false);
  }

  @Test(priority = 1, groups = {"all_os", "linux_os"}, enabled = false)
  public void linux_test() throws InterruptedException {
    System.out.println("linux test");
//    throw  new SkipException("my skip exception");
  }
}