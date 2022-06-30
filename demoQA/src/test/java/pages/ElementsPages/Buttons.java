package pages.ElementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Buttons {
    public WebDriver driver;

    public Buttons(WebDriver driver) {
        this.driver = driver;
    }

    By doubleClick = By.id("doubleClickBtn");
    By rightClick = By.id("rightClickBtn");
    By click = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button");

    By doubleClickMsg = By.id("doubleClickMessage");
    By rightClickMsg = By.id("rightClickMessage");
    By dynamicClickMsg = By.id("dynamicClickMessage");
    public WebElement getDoubleClick () {
        return driver.findElement(doubleClick);
    }
    public WebElement getRightClick () {
        return driver.findElement(rightClick);
    }
    public WebElement getClick () {
        return driver.findElement(click);
    }
    public WebElement getDoubleClickMsg () {
        return driver.findElement(doubleClickMsg);
    }
    public WebElement getRightClickMsg () {
        return driver.findElement(rightClickMsg);
    }
    public WebElement getDynamicClickMsg () {
        return driver.findElement(dynamicClickMsg);
    }
}

