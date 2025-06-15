package com.module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.se.helper.DriverFactory;
import com.utils.DemoHelper;

public class Test5_Complex {

    WebDriver driver;

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void byCssSelector_2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "savings.html");

        var checkbox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkbox.click();

    }

}
