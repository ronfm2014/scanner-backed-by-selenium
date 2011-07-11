package com.security.scanner.alternative.scanner;

import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidationReport {

    WebDriver driver;
    String vector;
    Boolean successful;

    public ValidationReport(WebDriver driver, String attackVector)
    {
        this.driver = driver;
        this.vector = attackVector;
    }

    public ValidationReport success(Boolean successful)
    {
        this.successful = successful;
        return this;
    }

    public void waitFor()
    {
        String alertText;
        try {
            alertText = driver.switchTo().alert().getText();
        } catch (NullPointerException npe) {
            alertText = null;
        }

        if (null != alertText)
        {
            assertTrue("Attack failed for vector: " + vector, successful);
        } else
        {
            assertFalse("Attack failed for vector: " + vector, successful);
        }
    }

}
