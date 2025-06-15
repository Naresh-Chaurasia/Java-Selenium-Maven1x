package com.m1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4_TypingTest {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void typingTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "index.html");

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement dob = driver.findElement(By.id("dob"));

        String s = "How are you?";
        first.sendKeys("How are you?");
        first.submit();

        // first.sendKeys("Sofia");
        // last.sendKeys("Diaz");
        // email.sendKeys("sofia@email.com");
        // DemoHelper.pause();
        // email.clear();
        // email.sendKeys("sofia@email.com");
        dob.sendKeys("22/03/2022");

        // DemoHelper.pause();
        // driver.quit();
    }
}
