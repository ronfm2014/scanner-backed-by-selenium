package com.security.scanner.alternative.scanner;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.*;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidationReport {

    WebDriver driver;
    String vector;
    public int numberOfInjections = 0;
    public int numberOfSuccesses = 0;
    public int numberOfFailures = 0;

    public ValidationReport(WebDriver driver, String attackVector) {
        this.driver = driver;
        this.vector = attackVector;
    }

    public void waitFor() {
        numberOfInjections++;
        try {

            Alert alertXss = driver.switchTo().alert();
            if (alertXss.getText().contains("CrossSiteScriptingAcademia")) {
                System.out.println("Attack succeeded for vector: " + vector + " on page " + driver.getCurrentUrl());
                numberOfSuccesses++;
            }
            else
            {
                Object payloadToExecute = ((JavascriptExecutor) driver).executeScript("return (document.evaluate(\"//@*[contains(.,'CrossSiteScriptingAcademia')]\", document, null, XPathResult.STRING_TYPE, null)).stringValue");
                ((JavascriptExecutor) driver).executeScript(payloadToExecute.toString());
            }
            alertXss.dismiss();
        } catch (WebDriverException wde) {
            //System.out.println("Attack failed for vector: " + vector + " on page " + driver.getCurrentUrl());
            numberOfFailures++;
        } catch (NullPointerException npe) {
            //System.out.println("Attack failed for vector: " + vector + " on page " + driver.getCurrentUrl());
            numberOfFailures++;
        }
    }
}
