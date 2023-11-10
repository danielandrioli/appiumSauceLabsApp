package com.daniboy.pageobjects;

import com.daniboy.pageobjects.components.Product;
import com.daniboy.pageobjects.components.ProductSortedBy;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BasePage {
    @AndroidFindBy(accessibility = "sort button")
    private WebElement sortBtn;
    @AndroidFindBy(accessibility = "store item")
    private List<WebElement> storeItemsWE;
    private List<Product> storeItems;

    public CatalogPage(AndroidDriver driver) {
        super(driver);
    }

    public ProductPage clickOnProduct(String productName) {
        //If the product in the list is outside the screen, it will perform a scroll action.
        String uiAutomatorText = ("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))").formatted(productName);
        driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorText)).click();

        return new ProductPage(driver);
    }

    public CatalogPage sortBy(ProductSortedBy sortedBy) {
        sortBtn.click();
        driver.findElement(AppiumBy.accessibilityId(sortedBy.getAccessibilityId())).click();
        return this;
    }

    public List<Product> getProducts() {
        storeItems = new ArrayList<>();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));  // I know the products won't be found, so I'm overriding the implicit wait from base page. This way, I'm not waiting 7 seconds every time.
//        for (WebElement itemWE : storeItemsWE) {} //Strangely, this for-each doesn't iterate! I had to create the loop below

        for (int i = 0; i < storeItemsWE.size(); i++) {
            WebElement storeItemWe = storeItemsWE.get(i);
            Product product;
            try {
                product = getProductFromStoreItemWE(storeItemWe);
            } catch (NoSuchElementException e) {
    /*
    Android driver can't get Web Elements that are not shown on the screen. They may be a little below the screen
    (as it is in this case in the Catalog Page) but the driver can find the Web Element only after scrolling.
    This is why I'm getting the elements that appear, and then scrolling till the footer.
     */
                String uiAutomatorText = "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().textContains(\"All Rights Reserved\").instance(0))";
                driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorText));
                product = getProductFromStoreItemWE(storeItemWe);
            }

            storeItems.add(product);
        }
        return storeItems;
    }

    private Product getProductFromStoreItemWE(WebElement storeItemWe) {
        String name = storeItemWe.findElement(AppiumBy.accessibilityId("store item text")).getText();
        double price = Double.parseDouble(storeItemWe
                .findElement(AppiumBy.accessibilityId("store item price")).getText().replace("$", ""));

        return new Product(name, price);
    }

    public CatalogPage scrollToTop() {
        String uiAutomatorText = "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textContains(\"Products\").instance(0))";
        driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorText));

        return this;
    }
}
