package pages.ElementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebTables {

    public WebDriver driver;
    public WebDriverWait wdWait;


    public WebTables(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    By row = By.className("rt-tr-group");
    By column = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div[1]");
    By edit = By.id("edit-record");
    By delete = By.id("delete-record");

    public List<WebElement> rows () {
        return driver.findElements(row);
    }
    public List<WebElement> columns () {
        return driver.findElements(column);
    }
    public List<WebElement> editBtns () {
        return driver.findElements(edit);
    }
    public List<WebElement> deleteBtns () {
        return driver.findElements(delete);
    }
    public int rowsCount () {
        return rows().size();
    }
    public int columnCount () {
        return columns().size();
    }
}

