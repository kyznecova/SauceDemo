package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com";
    public static final String CART = ".shopping_cart_link";
    public  static final String TITLE = "[class=title]";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TITLE)));
    }
}
