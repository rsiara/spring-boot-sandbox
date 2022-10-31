package testable;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryService implements IRetryAnalyzer {

  private static final int MAX_RETRY_NUMBER = 2;
  private int retryCount = 0;

  @Override
  public boolean retry(ITestResult iTestResult) {
    if (retryCount < MAX_RETRY_NUMBER) {
      retryCount++;
      System.out.println("Retry " + iTestResult.getName() + " retry number: " + retryCount);
      return true;
    }
    return false;
  }
}
