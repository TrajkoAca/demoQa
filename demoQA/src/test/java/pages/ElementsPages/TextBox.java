package pages.ElementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBox {

    public WebDriver driver;
    public WebDriverWait wdWait;

    public TextBox(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permAddress = By.id("permanentAddress");
    By submitButton = By.id("submit");
    By output = By.id("output");


    public WebElement getFullName () {
        return driver.findElement(fullName);
    }
    public WebElement getEmail () {
        return driver.findElement(email);
    }
    public WebElement getCurrentAddress () {
        return driver.findElement(currentAddress);
    }
    public WebElement getPermAddress () {
        return driver.findElement(permAddress);
    }
    public WebElement getSubmitButton () {
        return driver.findElement(submitButton);
    }
    public WebElement getOutput () {
        return driver.findElement(output);
    }
}
