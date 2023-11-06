package com.daniboy.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

//    private By usernameField = AppiumBy.accessibilityId("Username input field");
    @AndroidFindBy(accessibility = "Username input field")
    private WebElement usernameField;
    @AndroidFindBy(accessibility = "Password input field")
    private WebElement passwordField;
    @AndroidFindBy(accessibility = "Login button")
    private WebElement loginBtn;
    @AndroidFindBy(accessibility = "generic-error-message")
    private WebElement errorMsg;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public LoginPage login(String username, String password) {
        clearFields();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
        return this;
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
    }

    public Boolean isErrorMessageDisplayed() {
        return errorMsg.isDisplayed();
    }

}
