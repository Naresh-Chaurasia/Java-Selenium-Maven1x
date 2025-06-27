package com.m3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test2_ScreenshotTest {

    static WebDriver driver;

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/m3/";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "advanced.html");
        // DemoHelper.pause();
    }

    @Test
    public void testTakeScreenshot() throws IOException {

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Create file name with timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String destPath = "screenshot_" + timestamp + ".png";

        // Save the screenshot file
        Files.copy(src.toPath(), Paths.get(destPath));
        System.out.println("Screenshot saved to: " + destPath);
    }

    //@AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}