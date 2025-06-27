package com.m2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.se.helper.DriverFactory;
import com.utils.DemoHelper;

public class Test2_ByLinkTest {

    WebDriver driver;

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void click_Link() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "index.html");
        DemoHelper.pause();
        driver.findElement(By.linkText("Savings")).click();
    }

    @Test
    public void click_PartialLink() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "index.html");
        DemoHelper.pause();
        driver.findElement(By.partialLinkText("Reg")).click();

    }

}
