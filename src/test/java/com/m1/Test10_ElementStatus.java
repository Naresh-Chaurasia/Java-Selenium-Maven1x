package com.m1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.utils.DemoHelper;

public class Test10_ElementStatus {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void testIsDisplayed() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "webelement-status-demo.html");

        DemoHelper.pause();

        WebElement visibleInput = driver.findElement(By.id("visibleInput"));
        WebElement hiddenInput = driver.findElement(By.id("hiddenInput"));

        // Assertions.assertTrue(visibleInput.isDisplayed(), "Visible input should be
        // displayed");
        // Assertions.assertFalse(hiddenInput.isDisplayed(), "Hidden input should NOT be
        // displayed");

        System.out.println("Visible input is displayed: " + visibleInput.isDisplayed());
        System.out.println("Hidden inpu: " + hiddenInput.isDisplayed());

    }

    @Test
    public void testIsEnabled() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "webelement-status-demo.html");

        DemoHelper.pause();
        WebElement enabledInput = driver.findElement(By.id("enabledInput"));
        WebElement disabledInput = driver.findElement(By.id("disabledInput"));

        Assertions.assertTrue(enabledInput.isEnabled(), "Enabled input should be enabled");
        Assertions.assertFalse(disabledInput.isEnabled(), "Disabled input should be disabled");
    }

    @Test
    public void testIsSelected() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "webelement-status-demo.html");

        WebElement checkbox = driver.findElement(By.id("checkbox1"));
        WebElement radioMale = driver.findElement(By.id("radioMale"));
        WebElement radioFemale = driver.findElement(By.id("radioFemale"));

        Assertions.assertFalse(checkbox.isSelected(), "Checkbox should not be selected");
        Assertions.assertFalse(radioMale.isSelected(), "Male radio should not be selected");
        Assertions.assertTrue(!radioFemale.isSelected(), "Female radio should be selected");
    }

}
