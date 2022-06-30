package pages.ElementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Links {

    public WebDriver driver;
    public WebDriverWait wdWait;

    public Links(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    By link = By.tagName("a");
    By linkResponse = By.id("linkResponse");


    public List<WebElement> allLinks () {
       return driver.findElements(link);
    }

    public WebElement getLinkResponse () {
        return driver.findElement(linkResponse);
    }

    public void getLink () {
        for (int i = 0; i < allLinks().size(); i++) {
            WebElement w1 = allLinks().get(i);
            w1.click();
            System.out.println(w1);
        }
    }
}
