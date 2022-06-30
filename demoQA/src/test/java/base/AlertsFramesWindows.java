package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class AlertsFramesWindows {

    public WebDriver driver;
    public WebDriverWait wdWait;

    public AlertsFramesWindows(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }
    By pageBrowserWindows = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[1]");
    By newTab = By.id("tabButton");
    By newWindow = By.id("windowButton");
    By newWindowMsg = By.id("messageWindowButton");

    public WebElement getPageBrowserWindows () {
        return driver.findElement(pageBrowserWindows);
    }

    public WebElement getNewTab () {
        return driver.findElement(newTab);
    }
    public WebElement getNewWindow () {
        return driver.findElement(newWindow);
    }
    public WebElement getNewWindowMsg () {
        return driver.findElement(newWindowMsg);
    }
    public void switchToTab () {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void switchToWindow () {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}
