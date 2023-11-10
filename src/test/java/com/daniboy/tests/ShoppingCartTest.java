package com.daniboy.tests;

import com.daniboy.BaseAndroidSauceLabsTest;
import com.daniboy.pageobjects.CartPage;
import com.daniboy.pageobjects.ProductPage;
import com.daniboy.pageobjects.components.NavigationDrawer;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class ShoppingCartTest extends BaseAndroidSauceLabsTest {

    @Test
    public void verifyCartInformationIsCorrectAfterAddingProductToCart() {
        ProductPage page = new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToCatalogPage()
                .clickOnProduct("Sauce Labs Fleece Jacket")
                .increaseQuantity()
                .addToCart();

        Double itemPrice = page.getPrice();
        CartPage cartPage = page.clickOnCart();

        Assert.assertEquals(cartPage.getTotalPrice(), itemPrice * 2);
        Assert.assertEquals(cartPage.getTotalItens(), 2);
    }

    @Test
    public void verifyRemoveItemButtonWorks() {
        String productName = "Sauce Labs Bike Light";

        CartPage page = new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToCatalogPage()
                .clickOnProduct(productName)
                .addToCart()
                .clickOnCart()
                .removeItem(productName);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getLocalizedMessage());
        }
        /*
        In this specific case, Thread.sleep seems the best solution because I'm removing an item from the page and the get method
        below tries to get this element while it is being removed, so I get a stale element exception. WebDriverWait doesn't work
        because it'll wait till the element appears, but actually I don't want to wait till it appears, since I removed it
        intentionally. There are other solutions, but this seems the most practical.
         */
        List<String> productsOnCart = page.getProducts().stream().map(product -> product.getName()).toList();
        Assert.assertFalse(productsOnCart.contains(productName));
        log.info("verifyRemoveItemButtonWorks() - Products on cart: " + productsOnCart);
    }

    @Test
    public void verifyProductIsRemovedAfterDecreasingQuantityToZero() {
        String productName = "Test.allTheThings() T-Shirt";

        CartPage page = new NavigationDrawer(driver)
                .openNavigationDrawer()
                .goToCatalogPage()
                .clickOnProduct(productName)
                .addToCart()
                .clickOnCart()
                .clickOnMinusButton(productName);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getLocalizedMessage());
        }
        /*
        In this specific case, Thread.sleep seems the best solution because I'm removing an item from the page and the get method
        below tries to get this element while it is being removed, so I get a stale element exception. WebDriverWait doesn't work
        because it'll wait till the element appears, but actually I don't want to wait till it appears, since I removed it
        intentionally. There are other solutions, but this seems the most practical.
         */

        List<String> productsOnCart = page.getProducts().stream().map(product -> product.getName()).toList();
        Assert.assertFalse(productsOnCart.contains(productName));
        log.info("verifyProductIsRemovedAfterDecreasingQuantityToZero() - Products on cart: " + productsOnCart);
    }
}
