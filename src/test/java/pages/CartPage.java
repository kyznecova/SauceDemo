package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By CART_ITEM = By.cssSelector("[class=cart_item_label]");
    private final By ITEM_NAME = By.cssSelector(".inventory_item_name");

  public int countOfGoodsInCart() {
        List<WebElement> goodsList = driver.findElements(CART_ITEM);
        return goodsList.size();
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(ITEM_NAME);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }
}
