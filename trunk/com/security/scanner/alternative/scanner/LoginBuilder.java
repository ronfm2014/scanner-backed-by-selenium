package com.security.scanner.alternative.scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginBuilder implements Runnable{

    WebDriver driver;
    String username;
    String password;
    String urlToScan;

    public LoginBuilder (WebDriver driver, String username, String password, String urlToScan)
    {
        this.urlToScan = urlToScan;
        this.driver = driver;
        this.username = username;
        this.password = password;
    }

    public void run() {

        driver.get(urlToScan);
        WebElement userInput = driver.findElement(By.xpath("//input[@name='username']"));
        userInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("password");
        WebElement loginButton = driver.findElement(By.name("Login"));
        loginButton.click();
    }
}
