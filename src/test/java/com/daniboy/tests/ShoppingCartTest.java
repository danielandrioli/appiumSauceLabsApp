package com.daniboy.tests;

import com.daniboy.BaseAndroidSauceLabsTest;
import com.daniboy.pageobjects.CartPage;
import com.daniboy.pageobjects.ProductPage;
import com.daniboy.pageobjects.components.NavigationDrawer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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

        //erro (que as vezes nao ocorre) no getProducts abaixo. StaleElementReferenceException
        // isso ocorre, acredito, pq o item é removido e nao existe mais na página, deixando ele Stale quando tento pegar de novo
        // possível solução: dar um jeito de "atualizar" a página antes de executar o código abaixo
        //Solução q deu certo: colocar um sleep com 3000L. Thread.sleep é ruim, então dar um jeito de colocar um waits.
        //Lembre-se que o ProductRowOnCart não recebe um driver, então pense em como dar esse wait.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        List<String> productsOnCart = page.getProducts().stream().map(product -> product.getName()).toList();
        Assert.assertFalse(productsOnCart.contains(productName));
        System.out.println(productsOnCart); //LOG!
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
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        List<String> productsOnCart = page.getProducts().stream().map(product -> product.getName()).toList();
        Assert.assertFalse(productsOnCart.contains(productName));
        System.out.println(productsOnCart); //LOG!
    }


}
