package com.daniboy.pageobjects.components;

import com.daniboy.pageobjects.CatalogPage;
import com.daniboy.pageobjects.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class NavigationDrawer { //COLOCAR TUDO ANDROIDFINDBY
    private AppiumDriver driver;
    private By menuBy = AppiumBy.accessibilityId("open menu");
    private By logInBy = AppiumBy.accessibilityId("menu item log in");
    private By logOutBy = AppiumBy.accessibilityId("menu item log out");
    private By resetAppStateBy = AppiumBy.accessibilityId("menu item reset app");
    private By catalogBy = AppiumBy.accessibilityId("menu item catalog");

    public NavigationDrawer(AppiumDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    public NavigationDrawer openNavigationDrawer() {
        driver.findElement(menuBy).click();
        return this;
    }

    public LoginPage goToLoginPage() {
        driver.findElement(logInBy).click();
        return new LoginPage(driver);
    }

    public AlertDialog goToResetAppState() {
        driver.findElement(resetAppStateBy).click();
        return new AlertDialog(driver);
    }

    public AlertDialog goToLogout() {
        driver.findElement(logOutBy).click();
        return new AlertDialog(driver);
    }

    public CatalogPage goToCatalogPage() {
        driver.findElement(catalogBy).click();
        return new CatalogPage(driver);
    }

}
