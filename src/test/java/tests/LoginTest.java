package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Авторизация по корректным данным")
    public void correctLogin() {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"0000", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "loginData", description = "Авторизация по некорректным данным")
    public void blockedUserLogin(String user1, String password1, String expectedError) {
        loginPage.open();
        loginPage.login(user1, password1);
        assertEquals(loginPage.getTextError(), expectedError);
    }
}
