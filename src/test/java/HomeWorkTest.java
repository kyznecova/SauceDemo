import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomeWorkTest {
    @Test
    public void sauceDemo() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.tagName("input"));
        driver.findElement(By.xpath("//input[@type='password']"));
        driver.findElement(By.xpath("//input[@class='input_error form_input' and @type='password']"));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();

        driver.findElement(By.id("item_3_title_link"));
        driver.findElement(By.xpath("//a[text()='About']"));
        driver.findElement(By.xpath("//a[contains(@data-test,'reset')]"));
        driver.findElement(By.xpath("//a[contains(text(),'App')]"));
        driver.findElement(By.xpath("//*[text()='About']//ancestor::div"));

        driver.findElement(By.cssSelector("[class=bm-menu]"));
        driver.findElement(By.cssSelector(".bm-item.menu-item"));
        driver.findElement(By.cssSelector(".bm-menu .bm-item-list"));
        driver.findElement(By.cssSelector("#inventory_sidebar_link"));
        driver.findElement(By.cssSelector("nav"));
        driver.findElement(By.cssSelector("div.header_container"));
        driver.findElement(By.cssSelector("[value=az]"));

        driver.quit();
    }
}