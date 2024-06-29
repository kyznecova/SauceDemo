package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    @Step("Открытие браузера")
    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    @Step("Вводим данные пользователя {user} и {password}")
    public void login(String user, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).submit();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Получаем текст из сообщения об ошибке")
    public String getTextError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
