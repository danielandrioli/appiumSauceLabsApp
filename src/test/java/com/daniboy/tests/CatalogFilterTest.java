package com.daniboy.tests;

import com.daniboy.BaseAndroidSauceLabsTest;
import com.daniboy.pageobjects.CatalogPage;
import com.daniboy.pageobjects.components.Product;
import com.daniboy.pageobjects.components.ProductSortedBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CatalogFilterTest extends BaseAndroidSauceLabsTest {

    @Test
    public void verifyProductOrderAfterSortingByNameAscending() { //After the page is scrolled down, it doesn't scroll up automatically. So I need to start the test by going to the top of the page.
        List<Product> products = new CatalogPage(driver).scrollToTop().sortBy(ProductSortedBy.NAME_ASCENDING).getProducts();
        for (int i = 0; products.size() - 1 > i; i++) {
            Product product = products.get(i);
            Product nextProduct = products.get(i + 1);

            if (product.getName().compareToIgnoreCase(nextProduct.getName()) >= 0) {
                Assert.fail("The product list is not filtered by Name - Ascending.");
            }
        }
    }

    @Test
    public void verifyProductOrderAfterSortingByNameDescending() {
        List<Product> products = new CatalogPage(driver).scrollToTop().sortBy(ProductSortedBy.NAME_DESCENDING).getProducts();

        for (int i = 0; products.size() - 1 > i; i++) {
            Product product = products.get(i);
            Product nextProduct = products.get(i + 1);
            if (product.getName().compareToIgnoreCase(nextProduct.getName()) <= 0) {
                Assert.fail("The product list is not filtered by Name - Descending.");
            }
        }
    }

    @Test
    public void verifyProductOrderAfterSortingByPriceAscending() {
        List<Product> products = new CatalogPage(driver).scrollToTop().sortBy(ProductSortedBy.PRICE_ASCENDING).getProducts();

        for (int i = 0; products.size() - 1 > i; i++) {
            Product product = products.get(i);
            Product nextProduct = products.get(i + 1);
            if (product.getPrice() > nextProduct.getPrice()) {
                Assert.fail("The product list is not filtered by Price - Ascending.");
            }
        }
    }

    @Test
    public void verifyProductOrderAfterSortingByPriceDescending() {
        List<Product> products = new CatalogPage(driver).scrollToTop().sortBy(ProductSortedBy.PRICE_DESCENDING).getProducts();

        for (int i = 0; products.size() - 1 > i; i++) {
            Product product = products.get(i);
            Product nextProduct = products.get(i + 1);
            if (product.getPrice() < nextProduct.getPrice()) {
                Assert.fail("The product list is not filtered by Price - Descending.");
            }
        }
    }
}
