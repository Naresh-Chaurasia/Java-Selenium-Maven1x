package com.m1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.utils.DemoHelper;

public class Test9_ActionsDragDrop {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void testMouseHover() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "drag-drop.html");

        DemoHelper.pause();

        Actions actions = new Actions(driver);

        WebElement drag = driver.findElement(By.id("drag"));
        WebElement drop = driver.findElement(By.id("drop"));

        String text = drop.getText();
        System.out.println("Drop text before: " + text);

        actions.dragAndDrop(drag, drop).perform();

        // Optional validation: check if drop text changed
        text = drop.getText();
        System.out.println("Drop text after: " + text);
    }

}