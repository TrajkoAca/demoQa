package pages.ElementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBox {
    public WebDriver driver;
    public WebDriverWait wdWait;

    public CheckBox(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }
    By checkBoxBtn = By.className("rct-checkbox");
    By expandAll = By.cssSelector(".rct-icon.rct-icon-expand-all");
    By collapseBtn = By.cssSelector(".rct-icon.rct-icon-collapse-all");

    public WebElement getCheckBoxBtn () {
        return driver.findElement(checkBoxBtn);
    }
    public WebElement getExpandAllBtn () {
        return driver.findElement(expandAll);
    }
    public WebElement getCollapseBtn () {
        return driver.findElement(collapseBtn);
    }
}
