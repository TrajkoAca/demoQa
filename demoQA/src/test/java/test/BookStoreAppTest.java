package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class BookStoreAppTest extends BasePage {

    @BeforeMethod
    public void setUp() {

        driver.navigate().to("https://demoqa.com/login");
        driver.manage().window().maximize();
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void login () throws InterruptedException {
        loginPage.getUserName().sendKeys("Trajkoaca");
        loginPage.getPassword().sendKeys("Kopacka12345!@");
        loginPage.getLoginBtn().click();
        Thread.sleep(3500);
        WebElement nameDisplayed = driver.findElement(By.id("userName-value"));
        Assert.assertTrue(nameDisplayed.isDisplayed());
    }
    @Test
    public void fromProfileToStore () throws InterruptedException {
        login();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", profilePage.getBackToStore());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
    }
    @Test
    public void deleteAllBooks () throws InterruptedException {
        login();
        profilePage.getDeleteAllBooksBtn().click();
        profilePage.modalBtn();
        driver.switchTo().alert().accept();

    }
    @Test
    public void collectionSearch () throws InterruptedException {
        login();
        WebElement search = profilePage.getSearchBox();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", search);
        search.click();
    }
    @Test
    public void logout () throws InterruptedException {
        login();
        WebElement logoutBtn = profilePage.getLogoutBtn();
        logoutBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
    }

    @Test
    public void switchNumOfRows () throws InterruptedException {
        login();
        WebElement rows = profilePage.getNumberOfRows();
        rows.click();
        Select s = new Select(rows);
        s.selectByIndex(1);
        Assert.assertEquals(rows.getAttribute("value"), "10");
    }
    /*@Test
    public void deleteAcc () throws InterruptedException {       // DO LAST
        login();
        WebElement delete = profilePage.getDeleteAccBtn();
        delete.click();
        profilePage.modalBtn();
        Thread.sleep(3500);
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
    }*/

}
