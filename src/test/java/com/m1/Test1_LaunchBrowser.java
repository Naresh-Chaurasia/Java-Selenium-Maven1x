package com.m1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_LaunchBrowser {
    private WebDriver driver;

    @Test
    public void testExample() {

        driver = new ChromeDriver();
        driver.quit();
    }

}