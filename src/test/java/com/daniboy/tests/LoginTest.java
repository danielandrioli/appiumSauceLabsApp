package com.daniboy.tests;

import com.daniboy.BaseAndroidSauceLabsTest;
import com.daniboy.pageobjects.CatalogPage;
import com.daniboy.pageobjects.LoginPage;
import com.daniboy.pageobjects.components.NavigationDrawer;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseAndroidSauceLabsTest {

    @Test
    public void loginWithValidCredentialsShouldSucceed() {
        new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToLoginPage()
                .login("bob@example.com", "10203040");

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Products\" and @class=\"android.widget.TextView\"]"))
                .getText(), "Products");
    }

    @Test
    public void loginWithInvalidCredentialsShouldFail() {
        LoginPage loginPg = new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToLoginPage()
                .login("doesntexist@example.com", "10203040");

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Login\"])[1]"))
                .getText(), "Login"); // Assert user stays in the same page

        Assert.assertTrue(loginPg.isErrorMessageDisplayed());
    }

    @Test(dependsOnMethods = "loginWithValidCredentialsShouldSucceed")
    public void logoutShouldRedirectToLoginPage() {
        new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToLogout()
                .confirm();

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Login\"])[1]"))
                .getText(), "Login");
    }
}
