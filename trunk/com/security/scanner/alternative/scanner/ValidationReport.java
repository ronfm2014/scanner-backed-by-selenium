package com.security.scanner.alternative.scanner;

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
        if (hasPayloadTriggeredWhenEventFired()) {
            System.out.println("Attack succeeded for vector: " + vector + " on page " + driver.getCurrentUrl());
        }
    }

    private boolean hasPayloadTriggeredWhenEventFired() {
        try {
            Object payloadToExecute = ((JavascriptExecutor) driver).executeScript("return (document.evaluate(\"//@*[contains(.,'CrossSiteScriptingAcademia')]\", document, null, XPathResult.STRING_TYPE, null)).stringValue");
            ((JavascriptExecutor) driver).executeScript(payloadToExecute.toString());
            return hasPayloadTriggeredThroughAlert();
        } catch (WebDriverException wde) {
        } catch (NullPointerException npe) {
        }
        return false;
    }

    private boolean hasPayloadTriggeredThroughAlert() {
        try {
            Alert alertXss = driver.switchTo().alert();
            alertXss.dismiss();
            return (alertXss.getText().contains("CrossSiteScriptingAcademia"));
        } catch (WebDriverException wde) {
        } catch (NullPointerException npe) {
        }
        return false;
    }
}
