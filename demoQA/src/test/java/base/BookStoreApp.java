package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStoreApp {
    public WebDriver driver;
    public WebDriverWait wdWait;

    public BookStoreApp(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }
    By login = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]");
    By bookstore = By.xpath("//*[@id=\"item-2\"]");
    By profile = By.xpath("//*[@id=\"item-3\"]");
    By bookStoreAPI = By.xpath("//*[@id=\"item-4\"]");

    public WebElement getLogin () {
        return driver.findElement(login);
    }
    public WebElement getBookstore () {
        return driver.findElement(bookstore);
    }
    public WebElement getProfile () {
        return driver.findElement(profile);
    }
    public WebElement getBookStoreAPI () {
        return driver.findElement(bookStoreAPI);
    }
}
