package com.daniboy.tests;

import com.daniboy.BaseAndroidSauceLabsTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class MainActivityTest extends BaseAndroidSauceLabsTest {

    @Test(priority = -1)
    public void activityDefinition() {
        options.setAppActivity(".MainActivity");
    }

    @Test
    public void firstTest() {
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@class=\"android.widget.ImageView\"])[6]")).click();
    }
}
