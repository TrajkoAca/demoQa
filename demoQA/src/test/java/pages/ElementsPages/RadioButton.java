package pages.ElementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButton {

    public WebDriver driver;
    public WebDriverWait wdWait;

    public RadioButton(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    By buttonYes = By.cssSelector(".custom-control-label");
    By buttonImpressive = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    By buttonNo = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[4]/label");
    By messageYes = By.cssSelector(".mt-3");
    By messageImpressive = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p");

    public WebElement getYesBtn () {
        return driver.findElement(buttonYes);
    }
    public WebElement getImpressiveBtn () {
        return driver.findElement(buttonImpressive);
    }
    public WebElement getNoBtn () {
        return driver.findElement(buttonNo);
    }
    public WebElement getTextYes () {
        return driver.findElement(messageYes);
    }
    public WebElement getTextImpressive () {
        return driver.findElement(messageImpressive);
    }
}
