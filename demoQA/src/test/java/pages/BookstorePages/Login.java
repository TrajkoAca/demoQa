package pages.BookstorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    public WebDriver driver;
    public WebDriverWait wdWait;


    public Login(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    By userName = By.id("userName");
    By password = By.id("password");
    By loginBtn = By.id("login");

    public WebElement getUserName () {
        return driver.findElement(userName);
    }
    public WebElement getPassword () {
        return driver.findElement(password);
    }
    public WebElement getLoginBtn () {
        return driver.findElement(loginBtn);
    }
}
