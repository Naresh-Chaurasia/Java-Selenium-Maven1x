package com.m1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.se.helper.DriverFactory;
import com.utils.DemoHelper;

public class Test5_ClickingAdvanced {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void moreClicking() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "index.html");

        WebElement checkbox = driver.findElement(By.id("heard-about"));

        Actions actions = new Actions(driver);

        // actions.doubleClick(checkbox).perform();

        // Right Click
        actions.contextClick(checkbox).perform();

        DemoHelper.pause();
        // driver.quit();
    }
}
