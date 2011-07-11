package com.security.scanner.alternative.scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Attacker implements Runnable{

    String attackVector;
    String url;
    WebDriver driver;
    List<WebElement> allInputs = new ArrayList<WebElement>();
    List<WebElement> allForms = new ArrayList<WebElement>();

    public Attacker (WebDriver driver, String urlToAttack)
    {
        this.driver = driver;
        this.url = urlToAttack;
    }

    public Attacker using(String attackVector)
    {
        this.attackVector = attackVector;
        return this;
    }

    public void run() {

        allForms = driver.findElements(By.xpath("//form"));
        for (WebElement form: allForms)
        {
            allInputs = form.findElements(By.xpath(".//input"));
            allInputs.addAll(form.findElements(By.xpath(".//textarea")));
            for (WebElement input : allInputs) {

                if (input.isDisplayed() && input.isEnabled() && input.getAttribute("type")!="submit") {
                    input.sendKeys(attackVector);
                }
            }

            form.findElement(By.xpath(".//input[@type='submit']")).click();
            break;
        }


    }
}
