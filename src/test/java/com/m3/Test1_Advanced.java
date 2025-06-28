package com.m3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.utils.DemoHelper;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test1_Advanced {

    WebDriver driver;
    Actions actions;
    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/m3/";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PREFIX + "advanced.html");
        actions = new Actions(driver);
        // DemoHelper.pause();
    }

    @Test
    public void testRightClick() {
        WebElement rightClickBtn = driver.findElement(By.id("rightClickButton"));
        DemoHelper.pause();
        actions.contextClick(rightClickBtn).perform();
    }

    @Test
    public void testDoubleClick() {
        WebElement dblClickBtn = driver.findElement(By.id("doubleClickButton"));
        DemoHelper.pause();
        actions.doubleClick(dblClickBtn).perform();
    }

    @Test
    public void testMouseHover() {
        WebElement menu = driver.findElement(By.id("menu"));
        DemoHelper.pause();
        actions.moveToElement(menu).perform();
    }

    @Test
    @Order(5)
    /**
     * Purpose: Sometimes, Selenium’s standard API can’t interact with certain
     * elements or perform actions (like scrolling, manipulating DOM, etc.).
     * JavascriptExecutor lets you run raw JavaScript to overcome these limitations.
     * Usage: You typically cast your WebDriver instance to JavascriptExecutor and
     * then call executeScript or executeAsyncScript
     */
    public void testScrollDownByPixels() {
        DemoHelper.pause();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
    }

    @Test
    public void testScrollIntoView() {
        WebElement element = driver.findElement(By.id("footer"));
        DemoHelper.pause();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Test
    public void testKeyboardEnter() {
        WebElement input = driver.findElement(By.id("searchBox"));
        input.sendKeys("Selenium");
        input.sendKeys(Keys.ENTER);
    }

    @Test
    public void testSendKeysWithShift() {
        WebElement input = driver.findElement(By.id("capitalText"));
        DemoHelper.pause();
        actions.keyDown(Keys.SHIFT).sendKeys(input, "selenium").keyUp(Keys.SHIFT).perform();
    }

    // @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
