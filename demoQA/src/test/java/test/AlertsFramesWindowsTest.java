package test;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AlertsFramesWindowsTest extends BasePage {

    @BeforeMethod
    public void setUp() {
        driver.navigate().to("https://demoqa.com/alertsWindows");
        driver.manage().window().maximize();
    }
    @Test
    public void alertsFramesWindowOpened () throws InterruptedException {
        WebElement w1 = alertsFramesWindowsPage.getPageBrowserWindows();
        Thread.sleep(3000);
        w1.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/browser-windows");
    }
    @Test
    public void newTab () throws InterruptedException {
        alertsFramesWindowOpened();
        WebElement button = alertsFramesWindowsPage.getNewTab();
        button.click();
        String url = "https://demoqa.com/sample";
        alertsFramesWindowsPage.switchToTab();
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test
    public void newWindow () throws InterruptedException {
        alertsFramesWindowOpened();
        WebElement button = alertsFramesWindowsPage.getNewWindow();
        button.click();
        String url = "https://demoqa.com/sample";
        alertsFramesWindowsPage.switchToWindow();
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

}

