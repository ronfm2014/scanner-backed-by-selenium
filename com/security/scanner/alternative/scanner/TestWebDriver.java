package com.security.scanner.alternative.scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestWebDriver {

    File attackVectorFile;
    WebDriver driver;

    public TestWebDriver (String url)
    {
        this.driver = new FirefoxDriver();
//      this.driver = new HtmlUnitDriver(true);
        driver.get(url);
    }

    public Attacker attack (String url) {

        return new Attacker(url).using(attackVectorFile);
    }
}
