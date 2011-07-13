package com.security.scanner.alternative.scanner;

import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidationReport {

    WebDriver driver;
    String vector;

    public ValidationReport(WebDriver driver, String attackVector)
    {
        this.driver = driver;
        this.vector = attackVector;
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
            System.out.println("Attack succeeded for vector: " + vector);
        } else
        {
            System.out.println("Attack succeeded for vector: " + vector);
        }
    }
}
