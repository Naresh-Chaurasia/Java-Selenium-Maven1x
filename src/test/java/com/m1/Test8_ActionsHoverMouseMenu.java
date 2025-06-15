package com.m1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.utils.DemoHelper;

public class Test8_ActionsHoverMouseMenu {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void testMouseHover() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "actions-demo.html");

        DemoHelper.pause();

        Actions actions = new Actions(driver);

        WebElement menu = driver.findElement(By.id("menu"));
        
        
        
        actions.moveToElement(menu).perform();
    }

}