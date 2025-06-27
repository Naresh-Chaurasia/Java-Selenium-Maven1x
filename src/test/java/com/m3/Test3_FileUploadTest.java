package com.m3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.utils.DemoHelper;

import java.nio.file.Paths;

public class Test3_FileUploadTest {

    WebDriver driver;
    Actions actions;
    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/m3/";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "upload.html");
        actions = new Actions(driver);
        // DemoHelper.pause();
    }

    @Test
    public void testFileUpload() {

        // Locate the file input element
        WebElement uploadInput = driver.findElement(By.id("fileInput"));

        // Get absolute path of the file to upload
        String filePath = Paths.get("/Users/nareshchaurasia/nc/Training-Code-Projects/Java-Selenium-Maven1x/pom.xml")
                .toAbsolutePath().toString();
        uploadInput.sendKeys(filePath);

        DemoHelper.pause();

        // Click the upload button
        driver.findElement(By.id("uploadBtn")).click();

        // Optional: Add assertion (if upload triggers some result)
        System.out.println("File uploaded: " + filePath);
    }

    // @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
