package com.m3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.se.helper.DemoHelper;

public class AlertFramePopupTest {

    WebDriver driver;

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/m3/";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "alert-frame-popup.html");
        DemoHelper.pause();
    }

    @Test
    public void testAlert() {
        driver.findElement(By.xpath("//button[text()='Show Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        DemoHelper.pause();
        alert.accept();
    }

    @Test
    public void testPopup() {
        driver.findElement(By.xpath("//button[text()='Show Popup']")).click();
        WebElement popup = driver.findElement(By.id("popup"));
        Assertions.assertTrue(popup.isDisplayed(), "Popup should be visible");
        DemoHelper.pause();
        driver.findElement(By.xpath("//div[@id='popup']//button[text()='Close']")).click();
    }

    @Test
    public void testIframe() {
        driver.switchTo().frame("testFrame");
        WebElement para = driver.findElement(By.tagName("p"));
        Assertions.assertEquals("This is content inside an iframe", para.getText());
        driver.switchTo().defaultContent();
    }

    // @AfterEach
    public void tearDown() {
        driver.quit();
    }
}