package com.daniboy.pageobjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CatalogPage extends BasePage {

    public CatalogPage(AndroidDriver driver) {
        super(driver);
    }

    public ProductPage clickOnProduct(String productName) {
        //If the product in the list is outside the screen, it will perform a scroll action.
        String uiAutomatorText = ("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))").formatted(productName);
        driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorText)).click();

        return new ProductPage(driver);
    }
}
