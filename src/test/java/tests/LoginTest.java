package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(driver.findElement(By.cssSelector("[class=title]")).getText(), "Products");
    }

    @Test
    public void blockedUserLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(driver.findElement(By.cssSelector("[data-test=error]")).getText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void incorrectPassword() {
        loginPage.open();
        loginPage.login("standard_user", "0000");
        assertEquals(driver.findElement(By.cssSelector("[data-test=error]")).getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("0000", "secret_sauce");
        assertEquals(driver.findElement(By.cssSelector("[data-test=error]")).getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
