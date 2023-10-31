package com.daniboy.pageobjects.components;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AlertDialog {  // This alert dialog is the same for all dialogs.
    private AppiumDriver driver;
    private By confirtmBtn = AppiumBy.id("android:id/button1");
    private By cancelBtn = AppiumBy.id("android:id/button2");
    private By okBtn = AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\" and @text='OK']");

    public AlertDialog(AppiumDriver driver) {
        this.driver = driver;
    }

    public void confirm() {
        driver.findElement(confirtmBtn).click();
        driver.findElement(okBtn).click();
    }

    public void cancel() {
        driver.findElement(cancelBtn).click();
    }
}
