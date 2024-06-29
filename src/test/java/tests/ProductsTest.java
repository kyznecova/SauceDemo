package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ProductsTest extends BaseTest {

    private String goodsName = "Sauce Labs Bike Light";

    @Test(description = "Проверка верного добавления товаров в корзину")
    public void buyProduct() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.isOpened();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart(goodsName);
        productsPage.addToCart(5);
        productsPage.openCart();
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
