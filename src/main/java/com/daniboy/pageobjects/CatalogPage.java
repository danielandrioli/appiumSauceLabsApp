package com.daniboy.pageobjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class CatalogPage extends BasePage {

    public CatalogPage(AppiumDriver driver) {
        super(driver);
    }

    public ProductPage clickOnProduct(String productName) {
        String xpath = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"%s\"]"
                .formatted(productName);
        driver.findElement(AppiumBy.xpath(xpath)).click();

        return new ProductPage(driver);
    }
}
