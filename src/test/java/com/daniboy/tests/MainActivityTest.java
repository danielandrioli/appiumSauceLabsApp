package com.daniboy.tests;

import com.daniboy.BaseAndroidSauceLabsTest;
import io.appium.java_client.AppiumBy;

public class MainActivityTest extends BaseAndroidSauceLabsTest {


//    @Test
    public void firstTest() {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Bike Light\"]")).click();
        int listSize = driver.findElements(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])")).size();
        System.out.println("Tamanho da lista: " + listSize);
    }
}
