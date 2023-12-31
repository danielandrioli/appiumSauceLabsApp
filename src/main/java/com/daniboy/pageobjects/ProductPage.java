package com.daniboy.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    @AndroidFindBy(accessibility = "product price")
    private WebElement price;
    @AndroidFindBy(accessibility = "counter plus button")
    private WebElement plusBtn;
    @AndroidFindBy(accessibility = "counter minus button")
    private WebElement minusBtn;
    @AndroidFindBy(accessibility = "Add To Cart button")
    private WebElement addToCartBtn;

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return header.getText();
    }

    public Double getPrice() {
        return Double.parseDouble(price.getText().replace("$", ""));
    }

    public ProductPage increaseQuantity() {
        plusBtn.click();
        return this;
    }

    public ProductPage decreaseQuantity() {
        minusBtn.click();
        return this;
    }

    public ProductPage addToCart() {
        addToCartBtn.click();
        return this;
    }

    public boolean isAddToCartBtnEnabled() {
        return addToCartBtn.isEnabled();
    }
}
