package com.security.scanner.alternative.scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestWebDriver {

    String urlToScan;
    WebDriver driver;

    public TestWebDriver (WebDriver driver)
    {
        this.driver = driver;
//      this.driver = new HtmlUnitDriver(true);
    }

    public Attacker attack (String urlToScan) {

        this.urlToScan = urlToScan;
        driver.get(this.urlToScan);
        return new Attacker(this.urlToScan, this.driver);
    }

    public LoginBuilder login (String username, String password)
    {
       return new LoginBuilder(driver, username, password);
    }
}
