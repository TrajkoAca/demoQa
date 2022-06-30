package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

    public WebDriver driver;
    public WebDriverWait wdWait;

    public Elements(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    By textBox = By.id("item-0");
    By checkBox = By.id("item-1");
    By radioButton = By.id("item-2");
    By webTables = By.id("item-3");
    By buttons = By.id("item-4");
    By links = By.id("item-5");
    By brokenLinksAndImg = By.id("item-6");
    By uploadAndDownload = By.id("item-7");
    By dynamicProp = By.id("item-8");



    public WebElement getTextBox () {
        return driver.findElement(textBox);
    }
    public WebElement getCheckBox () {
        return driver.findElement(checkBox);
    }
    public WebElement getRadioButton () {
        return driver.findElement(radioButton);
    }
    public WebElement getWebTables () {
        return driver.findElement(webTables);
    }
    public WebElement getButtons () {
        return driver.findElement(buttons);
    }
    public WebElement getLinks () {
        return driver.findElement(links);
    }
    public WebElement getBrokenLinksAndImg () {
        return driver.findElement(brokenLinksAndImg);
    }
    public WebElement getUplAndDwl () {
        return driver.findElement(uploadAndDownload);
    }
    public WebElement getDynamicProp () {
        return driver.findElement(dynamicProp);
    }


}
