package com.daniboy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Platform;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseAndroidSauceLabsTest {

    protected AndroidDriver driver;
    protected UiAutomator2Options options;

    @BeforeClass
    public void setup() {
        options = getAndroidSauceLabsOptions();
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException exception) {
            System.out.println("Exception! " + exception.getLocalizedMessage());
        }

    }

    private UiAutomator2Options getAndroidSauceLabsOptions() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //Optional. It's the default value.
        options.setPlatformName(Platform.ANDROID.name()); //Optional. It's the default value.

        options.setPlatformName("13");
        options.setDeviceName("emulator-5554");

        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        return options;
    }
}
