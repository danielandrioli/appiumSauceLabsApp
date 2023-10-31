package com.daniboy.pageobjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By usernameField = AppiumBy.accessibilityId("Username input field");
    private By passwordField = AppiumBy.accessibilityId("Password input field");
    private By loginBtn = AppiumBy.accessibilityId("Login button");
    private By errorMsg = AppiumBy.accessibilityId("generic-error-message");


    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public LoginPage login(String username, String password) {
        clearFields();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
        return this;
    }

    private void clearFields() {
        driver.findElement(usernameField).clear();
        driver.findElement(passwordField).clear();
    }

    public Boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

}
