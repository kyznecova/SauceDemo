package tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class CartTest extends BaseTest{

    private String goodsName = "Sauce Labs Bike Light";

    @Test
    public void goodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isOpened();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart(goodsName);
        productsPage.addToCart(5);
        productsPage.openCart();
        cartPage.isOpened();
        assertEquals(cartPage.countOfGoodsInCard(), 3);
    }
}
