package com.daniboy.tests;

import com.daniboy.BaseAndroidSauceLabsTest;
import com.daniboy.pageobjects.components.NavigationDrawer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseAndroidSauceLabsTest {
    @Test
    public void verifyAddToCartButtonIsDisabledAfterDecreasingQuantityToZero() {
        boolean isAddToCartBtnEnabled = new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToCatalogPage()
                .clickOnProduct("Sauce Labs Onesie")
                .decreaseQuantity()
                .isAddToCartBtnEnabled();

        Assert.assertFalse(isAddToCartBtnEnabled);
    }
}
