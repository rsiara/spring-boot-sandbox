package testable.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;

public class MyWebDriver extends ChromeDriver {

    @Override
    protected void log(SessionId sessionId, String commandName, Object toLog, When when) {
        System.out.println("LOG: sessionId: " + sessionId + " when: " + when + " commandName: " + commandName + " toLog: " + toLog);
        super.log(sessionId, commandName, toLog, when);
    }
}