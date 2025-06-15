package com.m1.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.se.helper.DemoHelper;

public class Test2_BasicNavigation {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void basicNavigationTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "index.html");

        DemoHelper.pause();

        driver.get(PREFIX + "page1.html");

        DemoHelper.pause();

        driver.navigate().back();
        DemoHelper.pause();

        driver.navigate().forward();
        DemoHelper.pause();

    }

    @Test
    public void displayPath() {

        System.out.println("-----");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(PREFIX + "index.html");

    }

}
