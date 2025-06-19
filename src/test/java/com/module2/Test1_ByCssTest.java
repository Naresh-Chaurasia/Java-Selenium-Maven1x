package com.module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.se.helper.DriverFactory;

public class Test1_ByCssTest {

    WebDriver driver;

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void byCssSelector_Id() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "savings.html");
        var datePicker = driver.findElement(By.cssSelector("#deposit"));
        datePicker.sendKeys("Deposit Amount 1");
    }

    @Test
    public void byCssSelector_Class() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "savings.html");
        var datePicker = driver.findElement(By.cssSelector(".form-control"));
        datePicker.sendKeys("Deposit Amount 2");

    }

    @Test
    public void byCssSelector() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "savings.html");
        var datePicker = driver.findElement(By.cssSelector("input[type=text]"));
        datePicker.sendKeys("10/12/2023");

    }

}
