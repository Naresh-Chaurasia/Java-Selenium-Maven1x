package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;

    // Locators
    By firstNameInput = By.id("firstName");
    By lastNameInput = By.id("lastName");
    By emailInput = By.id("email");
    By dobInput = By.id("dob");
    By heardAboutCheckbox = By.id("heard-about");
    By textarea = By.id("textarea");
    By clearButton = By.id("clear");
    By registerButton = By.id("register");
    By saveButton = By.id("save");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterDob(String dob) {
        driver.findElement(dobInput).clear();
        driver.findElement(dobInput).sendKeys(dob);
    }

    public void checkHeardAbout() {
        WebElement checkbox = driver.findElement(heardAboutCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheckHeardAbout() {
        WebElement checkbox = driver.findElement(heardAboutCheckbox);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void enterTextarea(String text) {
        WebElement textareaElem = driver.findElement(textarea);
        textareaElem.clear();
        textareaElem.sendKeys(text);
    }

    public void clickClear() {
        driver.findElement(clearButton).click();
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    // Utility
    public boolean isTextareaEnabled() {
        return driver.findElement(textarea).isEnabled();
    }
}