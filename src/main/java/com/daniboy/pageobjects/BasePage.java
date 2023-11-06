package com.daniboy.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    @AndroidFindBy(accessibility = "cart badge")
    protected WebElement cart;
    protected AndroidDriver driver;
    @AndroidFindBys({
            @AndroidBy(accessibility = "container header"),
            @AndroidBy(xpath = "(//android.widget.TextView[@class=\"android.widget.TextView\"])")
    })
    protected WebElement header;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CartPage clickOnCart() {
        cart.click();
        return new CartPage(driver);
    }

    public String getHeaderText() { return header.getText(); }
}
