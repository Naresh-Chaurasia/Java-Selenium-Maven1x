package com.m2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.se.helper.DriverFactory;
import com.utils.DemoHelper;

public class Test5_XPath {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "xpath.html");
        DemoHelper.pause();
    }

    @Test
    public void testFindById() {
        WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
        user.sendKeys("testUser");
    }

    @Test
    public void testContainsInName() {
        WebElement input = driver.findElement(By.xpath("//input[contains(@name, 'user')]"));
        input.sendKeys("containsTest");
    }

    @Test
    public void testButtonByText() {
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
        loginBtn.click();
    }

    @Test
    public void testMultipleAttributes() {
        WebElement element = driver.findElement(By.xpath("//input[@type='text' and @name='username']"));
        element.sendKeys("multiAttr");
    }

    @Test
    public void testStartsWith() {
        WebElement element = driver.findElement(By.xpath("//input[starts-with(@name, 'user')]"));
        element.sendKeys("startsWith");
    }

    @Test
    public void testOrCondition() {
        WebElement element = driver.findElement(By.xpath("//input[@id='email' or @name='email']"));
        element.sendKeys("orCondition");
    }

    @Test
    public void testUsingIndex() {
        WebElement secondInput = driver.findElement(By.xpath("(//input)[2]"));
        secondInput.sendKeys("secondInput");
    }

}
