package com.daniboy.pageobjects;

import com.daniboy.pageobjects.components.Product;
import com.daniboy.pageobjects.components.ProductRowOnCart;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

public class CartPage extends BasePage {
    @AndroidFindBy(accessibility = "product row")
    private List<WebElement> productRows;
    @AndroidFindBy(accessibility = "total number")
    private WebElement totalProductsQuantity;
    @AndroidFindBy(accessibility = "total price")
    private WebElement totalPrice;

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    public int getTotalItens() {
        return Integer.parseInt(totalProductsQuantity.getText().replace(" items", ""));
    }

    public double getTotalPrice() {
        return Double.parseDouble(totalPrice.getText().replace("$", ""));
    }

    private List<ProductRowOnCart> getProductRows() {
        return productRows.stream().map(webElement -> new ProductRowOnCart(webElement)).toList();
    }

    private ProductRowOnCart getProductRow(String productName) {
        return getProductRows().stream().filter(productRow -> productRow.getProduct().getName().equalsIgnoreCase(productName))
                .findFirst().orElseThrow();
    }

    public CartPage removeItem(String itemName) {
        getProductRow(itemName).clickOnRemoveItem();
        return this;
    }

    public CartPage clickOnMinusButton(String itemName) {
        getProductRow(itemName).clickOnMinusBtn();
        return this;
    }

    public CartPage clickOnPlusButton(String itemName) {
        getProductRow(itemName).clickOnPlusBtn();
        return this;
    }

    public List<Product> getProducts() {
        return getProductRows().stream().map(productRowOnCart -> productRowOnCart.getProduct()).toList();
    }



    //continuar aqui!!

    //Could be Predicate<Product>... But if the price change constantly, it'll break. I need the price to create new Product.
    /*
    private ProductRowOnCart getProductRow(Predicate<Product> condition) {
        return getProductRows().stream().filter(productRow -> condition.test(productRow.getProduct()))
                .findFirst().orElseThrow();
    }
     */

}
