package tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class CartTest extends BaseTest{

    private String goodsName = "Sauce Labs Bike Light";

    @Test(description = "Проверка количества добавленных товаров в корзину")
    public void goodsAdded() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.isOpened();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart(goodsName);
        productsPage.addToCart(5);
        productsPage.openCart();
        cartPage.isOpened();
        assertEquals(cartPage.countOfGoodsInCart(), 3);
    }
}
