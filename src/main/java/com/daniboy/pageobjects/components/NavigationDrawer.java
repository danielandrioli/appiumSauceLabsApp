package com.daniboy.pageobjects.components;

import com.daniboy.pageobjects.CatalogPage;
import com.daniboy.pageobjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NavigationDrawer {
    @AndroidFindBy(accessibility = "open menu")
    private WebElement menu;
    @AndroidFindBy(accessibility = "menu item log in")
    private WebElement login;
    @AndroidFindBy(accessibility = "menu item log out")
    private WebElement logout;
    @AndroidFindBy(accessibility = "menu item reset app")
    private WebElement resetAppState;
    @AndroidFindBy(accessibility = "menu item catalog")
    private WebElement catalog;


    private AndroidDriver driver;

    public NavigationDrawer(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public NavigationDrawer openNavigationDrawer() {
        menu.click();
        return this;
    }

    public LoginPage goToLoginPage() {
        login.click();
        return new LoginPage(driver);
    }

    public AlertDialog goToResetAppState() {
        resetAppState.click();
        return new AlertDialog(driver);
    }

    public AlertDialog goToLogout() {
        logout.click();
        return new AlertDialog(driver);
    }

    public CatalogPage goToCatalogPage() {
        catalog.click();
        return new CatalogPage(driver);
    }
}
