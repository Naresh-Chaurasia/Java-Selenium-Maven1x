package com.m1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Test7_FindMultipleElementsTest {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void multipleElementsTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "index.html");

        List<WebElement> feedback = driver.findElements(By.className("invalid-feedback"));

        print(feedback.get(0).getText());
        print(feedback.get(1).getText());

        driver.findElement(By.id("register")).click();
        print(feedback.get(0).getText());
        print(feedback.get(1).getText());

        driver.quit();
    }

    private void print(String text) {
        System.out.println("Feedback:" + text);
    }

}
