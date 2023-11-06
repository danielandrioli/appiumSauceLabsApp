package com.daniboy.pageobjects.components;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductRowOnCart {
    private By byProductLabel = AppiumBy.accessibilityId("product label");
    private By byProductPrice = AppiumBy.accessibilityId("product price");
    private By byProductQuantity = AppiumBy.accessibilityId("counter amount");
    private By byRemoveItemBtn = AppiumBy.accessibilityId("remove item");
    private By byPlusBtn = AppiumBy.accessibilityId("counter plus button");
    private By byMinusBtn = AppiumBy.accessibilityId("counter minus button");
    private WebElement root;
    private Product product;
    private int quantity;

    public ProductRowOnCart(WebElement root) {
        this.root = root;
        String productName = root.findElement(byProductLabel).getText();
        double productPrice = Double.parseDouble(root.findElement(byProductPrice).getText().replace("$", ""));
        quantity = Integer.parseInt(root.findElement(byProductQuantity)
                .findElement(AppiumBy.xpath("(//android.widget.TextView[@class=\"android.widget.TextView\"])"))
                .getText());
        product = new Product(productName, productPrice);
    }

    public ProductRowOnCart clickOnRemoveItem() {
        root.findElement(byRemoveItemBtn).click();
        return this;
    }

    public ProductRowOnCart clickOnMinusBtn() {
        root.findElement(byMinusBtn).click();
        return this;
    }

    public ProductRowOnCart clickOnPlusBtn() {
        root.findElement(byPlusBtn).click();
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
