package com.m1.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3_UnderstandingWebElement {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void webElementTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "index.html");

        WebElement first = driver.findElement(By.id("firstName"));
        System.out.println("Is firstName displayed? " + first.isDisplayed());
        System.out.println("getTagName? " + first.getTagName());

    }
}
