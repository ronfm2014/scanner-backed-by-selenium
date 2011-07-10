package com.security.scanner.alternative.scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Attacker implements Runnable{

    File attackVectorFile;
    String url;

    public Attacker (String url)
    {
        this.url = url;
    }

    public void run() {

    List<WebElement> allInputs = new ArrayList<WebElement>();
    List<WebElement> allForms = new ArrayList<WebElement>();
    List<String> attackVectors = new ArrayList<String>();

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

        try {
            driver.switchTo().alert();
        } catch (NullPointerException npe) {
            System.out.println("Attack failed for vector: " + attackVector);
        }

        driver.close();
    }

    public Attacker using(File attackVectorFile)
    {
        this.attackVectorFile = attackVectorFile;
        return this;
    }

    private void processAttackVectorFile()
    {
        try {
            this.aFileUtils.readLines(this.attackVectorFile);
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }



}
