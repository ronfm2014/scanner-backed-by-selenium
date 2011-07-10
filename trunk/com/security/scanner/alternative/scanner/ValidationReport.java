package com.security.scanner.alternative.scanner;

import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidationReport {

    WebDriver driver;
    String attackVector;
    Boolean successful;

    public ValidationReport(WebDriver driver, String attackVector)
    {
        this.driver = driver;
        this.attackVector = attackVector;
    }

    public ValidationReport success(Boolean successful)
    {
        this.successful = successful;
        return this;
    }

    public void waitFor()
    {
        try {
            driver.switchTo().alert();
            assertTrue("Attack failed for vector: " + attackVector, successful);
        } catch (NullPointerException npe) {
            assertFalse("Attack failed for vector: " + attackVector, successful);
        }
    }

}
