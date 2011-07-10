package com.security.scanner.alternative.scanner;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class SeleniumBadBoy {


    @Test
    public void testWebsiteForSecurityProblems() {

        TestWebDriver.attack("http://127.0.0.1/dvwa/vulnerabilities/xss_r/").using("src/resources/attackVector.txt").run();
    }

    SeleniumBadBoy(String url, String attackVector) {



        if (!loginHasBeenMade(driver))
        {
            login(driver);
//            visitXssStored(driver);
            visitXssReflected(driver);
        }


    }

    public void run()
    {
        for (String attackVector : attackVectors) {
//            SeleniumBadBoy2 testWebDriver = new SeleniumBadBoy2("http://localhost:8080/wavsep/RXSS-Detection-Evaluation-GET/Case11-Js2SingleQuoteJsEventScope.jsp?userinput=textvalue", attackVector);
//            SeleniumBadBoy2 testWebDriver = new SeleniumBadBoy2("http://testphp.vulnweb.com/", attackVector);
//            SeleniumBadBoy2 testWebDriver = new SeleniumBadBoy2("http://testphp.vulnweb.com/guestbook.php", attackVector);
//            SeleniumBadBoy testWebDriver = new SeleniumBadBoy("http://127.0.0.1/dvwa/vulnerabilities/xss_s/", attackVector);
            SeleniumBadBoy testWebDriver = new SeleniumBadBoy(this.url, this.attackVector);
        }
    }

    private boolean loginHasBeenMade(WebDriver driver)
    {
        WebElement userInput = driver.findElement(By.xpath("//input[@name='username']"));
        return !userInput.isDisplayed();
    }

    private void visitXssStored (WebDriver driver)
    {
        WebElement xssLink = driver.findElement(By.linkText("XSS stored"));
        xssLink.click();
    }

    private void visitXssReflected (WebDriver driver)
    {
        WebElement xssLink = driver.findElement(By.linkText("XSS reflected"));
        xssLink.click();
    }

}
