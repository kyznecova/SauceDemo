package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By BUTTON = By.xpath("//*[@class='inventory_item']//button");
    private final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

  public String getTitle() {
        return driver.findElement(By.cssSelector(TITLE)).getText();
    }

    public void addToCart(String product) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }

    public void addToCart(int index) {
        driver.findElements(BUTTON).get(index).click();
    }

    public void openCart() {
        driver.findElement(By.cssSelector(CART)).click();
    }
}
