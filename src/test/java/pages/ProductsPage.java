package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By BUTTON = By.xpath("//*[@class='inventory_item']//button");
    private final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    @Step("Проверка успешной авторизации")
    public String getTitle() {
        return driver.findElement(By.cssSelector(TITLE)).getText();
    }

    @Step("Добавляем товар в корзину")
    public void addToCart(String product) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Добавляем товар в корзину")
    public void addToCart(int index) {
        driver.findElements(BUTTON).get(index).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Переходим к Корзине")
    public void openCart() {
        driver.findElement(By.cssSelector(CART)).click();
        AllureUtils.takeScreenshot(driver);
    }
}
