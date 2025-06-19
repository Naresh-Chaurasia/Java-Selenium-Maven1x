package com.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class RegisterPageTest {

    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///Users/nareshchaurasia/nc/Training-Code-Projects/Java-Selenium-Maven1x/web/index.html");
        registerPage = new RegisterPage(driver);
    }

    // @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testFirstNameInput() {
        registerPage.enterFirstName("John");
        // Optionally assert value
        assertEquals("John", driver.findElement(registerPage.firstNameInput).getAttribute("value"));
    }

    @Test
    void testLastNameInput() {
        registerPage.enterLastName("Doe");
        assertEquals("Doe", driver.findElement(registerPage.lastNameInput).getAttribute("value"));
    }

    @Test
    void testEmailInput() {
        registerPage.enterEmail("john@example.com");
        assertEquals("john@example.com", driver.findElement(registerPage.emailInput).getAttribute("value"));
    }

    @Test
    void testDobInput() {
        registerPage.enterDob("1990-01-01");
        assertEquals("1990-01-01", driver.findElement(registerPage.dobInput).getAttribute("value"));
    }

    @Test
    void testHeardAboutCheckbox() {
        registerPage.checkHeardAbout();
        assertTrue(driver.findElement(registerPage.heardAboutCheckbox).isSelected());
        registerPage.uncheckHeardAbout();
        assertFalse(driver.findElement(registerPage.heardAboutCheckbox).isSelected());
    }

    @Test
    void testTextarea() {
        // Enable textarea first if needed
        registerPage.checkHeardAbout();
        // Wait or trigger JS if needed for enabling
        registerPage.enterTextarea("Test text");
        assertEquals("Test text", driver.findElement(registerPage.textarea).getAttribute("value"));
    }

    @Test
    void testClearButton() {
        registerPage.enterFirstName("Test");
        registerPage.clickClear();
        // Add assertions as per your clear logic
    }

    @Test
    void testRegisterButton() {
        registerPage.clickRegister();
        // Add assertions as per your register logic
    }

    @Test
    void testSaveButton() {
        registerPage.clickSave();
        // Add assertions as per your save logic
    }
}