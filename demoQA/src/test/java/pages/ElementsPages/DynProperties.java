package pages.ElementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynProperties {

    public WebDriver driver;
    public WebDriverWait wdWait;

    public DynProperties(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }
    By enableAfterBtn = By.id("enableAfter");
    By colorChangeBtn = By.id("colorChange");
    By visibleAfterBtn = By.id("visibleAfter");

    public WebElement getEnableAfterBtn () {
        return driver.findElement(enableAfterBtn);
    }
    public WebElement getColorChangeBtn () {
        return driver.findElement(colorChangeBtn);
    }
    public WebElement getVisibleAfterBtn () {
        return driver.findElement(visibleAfterBtn);
    }


}
