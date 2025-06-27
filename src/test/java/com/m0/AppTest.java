package com.m0;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utils.DemoHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/nareshchaurasia/nc/GenC/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();

    }

    @Test
    public void testExample() {

        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        assertEquals("Google", title);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}