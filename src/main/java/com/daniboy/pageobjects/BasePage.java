package com.daniboy.pageobjects;

import com.daniboy.pageobjects.components.NavigationDrawer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    @AndroidFindBy(accessibility = "cart badge")
    protected WebElement cart;
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CartPage clickOnCart() {
        cart.click();
        return new CartPage(driver);
    }

    public static NavigationDrawer navigate(AppiumDriver driver) { //será q colocar esse método estático aqui ou deixar
        return new NavigationDrawer(driver);                      // que estanciem o NavigationDrawer?
    }
}
