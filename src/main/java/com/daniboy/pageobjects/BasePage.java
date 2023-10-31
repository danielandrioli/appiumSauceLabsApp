package com.daniboy.pageobjects;

import com.daniboy.pageobjects.components.NavigationDrawer;
import io.appium.java_client.AppiumDriver;

public abstract class BasePage {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public static NavigationDrawer navigate(AppiumDriver driver) { //será q colocar esse método estático aqui ou deixar
        return new NavigationDrawer(driver);                      // que estanciem o NavigationDrawer?
    }
}
