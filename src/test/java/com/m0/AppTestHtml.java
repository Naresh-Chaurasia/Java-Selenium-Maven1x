package com.m0;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTestHtml {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/nareshchaurasia/nc/GenC/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        driver.get(
                "file:///Users/nareshchaurasia/nc/GenC/selenium-maven-project/src/test/java/com/example/sample.html");
    }

    @Test
    public void testInputFields() {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testuser");
        assertEquals("testuser", usernameField.getAttribute("value"));

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");
        assertEquals("password123", passwordField.getAttribute("value"));
    }

    @Test
    public void testButtons() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        assertTrue(loginButton.isDisplayed());

        WebElement cancelButton = driver.findElement(By.id("cancelButton"));
        assertTrue(cancelButton.isDisplayed());
    }

    @Test
    public void testCheckbox() {
        WebElement subscribeCheckbox = driver.findElement(By.id("subscribe"));
        subscribeCheckbox.click();
        assertTrue(subscribeCheckbox.isSelected());
    }

    @Test
    public void testRadioButtons() {
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[name='gender'][value='male']"));
        maleRadioButton.click();
        assertTrue(maleRadioButton.isSelected());

        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[name='gender'][value='female']"));
        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isSelected());
    }

    @Test
    public void testDropdown() {
        WebElement countryDropdown = driver.findElement(By.id("country"));
        countryDropdown.sendKeys("India");
        assertEquals("in", countryDropdown.getAttribute("value"));
    }

    @Test
    public void testTable() {
        WebElement firstRowName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        assertEquals("John Doe", firstRowName.getText());

        WebElement secondRowAge = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
        assertEquals("25", secondRowAge.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}