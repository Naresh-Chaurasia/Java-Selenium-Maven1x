package com.m1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utils.DemoHelper;

public class Test2_BasicNavigation {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void basicNavigationTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "index.html");

        System.out.println(PREFIX);
        System.out.println("--------------");

        DemoHelper.pause();
        driver.get(PREFIX + "savings.html");

        DemoHelper.pause();
        driver.navigate().back();

        DemoHelper.pause();
        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();
    }

}
