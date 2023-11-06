package com.daniboy.tests;

import com.daniboy.BaseAndroidSauceLabsTest;
import com.daniboy.pageobjects.LoginPage;
import com.daniboy.pageobjects.ProductPage;
import com.daniboy.pageobjects.components.NavigationDrawer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseAndroidSauceLabsTest {

    @Test
    public void loginWithValidCredentialsShouldSucceed() {
        new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToLoginPage()
                .login("bob@example.com", "10203040");

        Assert.assertEquals(new ProductPage(driver).getHeaderText(), "Products");
    }

    @Test
    public void loginWithInvalidCredentialsShouldFail() {
        LoginPage loginPage = new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToLoginPage()
                .login("doesntexist@example.com", "10203040");

        Assert.assertEquals(loginPage.getHeaderText(), "Login"); // Assert user stays in the same page
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(dependsOnMethods = "loginWithValidCredentialsShouldSucceed")
    public void logoutShouldRedirectToLoginPage() {
        new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToLogout()
                .confirm();

        Assert.assertEquals(new LoginPage(driver).getHeaderText(), "Login");
    }
}
