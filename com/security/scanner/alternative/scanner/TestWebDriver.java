package com.security.scanner.alternative.scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestWebDriver {

    WebDriver driver;
    private List<WebElement> allUrls;

    public TestWebDriver (WebDriver driver)
    {
        this.driver = driver;
    }

    public Attacker attack (String urlToAttack) {

        return new Attacker(driver, urlToAttack);
    }

    public ValidationReport executionReportFor(String vector)
    {
        return new ValidationReport(driver, vector);
    }

    public void shutdown()
    {
        driver.close();
    }
}
