package pages.BookstorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Profile {

    public WebDriver driver;
    public WebDriverWait wdWait;

    public Profile(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    By backToStore = By.id("gotoStore");
    By deleteAllBooksBtn = By.cssSelector(".text-right.button.di");
    By book = By.className("rt-tr-group");
    By searchBox = By.id("searchBox");
    By logoutBtn = By.xpath("//*[@id=\"submit\"]");
    By numberOfRows = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]/span[2]/select");
    By deleteAccBtn = By.cssSelector(".text-center.button");

    public WebElement getBackToStore () {
        return driver.findElement(backToStore);
    }
    public WebElement getDeleteAllBooksBtn () {
        return driver.findElement(deleteAllBooksBtn);
    }
    public WebElement getSearchBox () {
        return driver.findElement(searchBox);
    }
    public WebElement getLogoutBtn () {
        return driver.findElement(logoutBtn);
    }
    public WebElement getNumberOfRows () {
        return driver.findElement(numberOfRows);
    }
    public WebElement getDeleteAccBtn () {
        return driver.findElement(deleteAccBtn);
    }

    public void modalBtn () {
        WebElement modal = driver.findElement(By.className("modal-content"));
        WebElement modalOk = modal.findElement(By.id("closeSmallModal-ok"));
        //WebElement modalCancel = modal.findElement(By.id("closeSmallModal-cancel"));
        modalOk.click();
    }
        public List<WebElement> books () {
        return driver.findElements(book);
    }
}
