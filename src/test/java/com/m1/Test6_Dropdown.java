package com.m1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test6_Dropdown {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void selectingTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "savings.html");

        WebElement input = driver.findElement(By.id("deposit"));
        input.sendKeys("100");

        WebElement period = driver.findElement(By.id("period"));
        Select select = new Select(period);
        // select.selectByValue("2 Years-1");
        // DemoHelper.pause();
        select.selectByVisibleText("1 Year and 1 Months");
        // DemoHelper.pause();
        // select.selectByIndex(2);

        // WebElement result = driver.findElement(By.id("result"));
        // Assert.assertEquals(result.getText(), "After 2 Years you will earn $12.00 on
        // your deposit");

        // driver.quit();
    }
}
