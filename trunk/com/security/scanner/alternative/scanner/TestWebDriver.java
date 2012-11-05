package com.security.scanner.alternative.scanner;

import org.openqa.selenium.WebDriver;

public class TestWebDriver {

    WebDriver driver;

    public TestWebDriver (WebDriver driver)
    {
        this.driver = driver;
    }

    public Attacker attack (String urlToAttack)
    {
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
