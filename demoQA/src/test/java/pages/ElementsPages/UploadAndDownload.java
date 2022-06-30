package pages.ElementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;

public class UploadAndDownload {

    public WebDriver driver;
    public WebDriverWait wdWait;

    public UploadAndDownload(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    By downloadBtn = By.id("downloadButton");
    By uploadBtn = By.id("uploadFile");
    By uplMessage = By.id("uploadedFilePath");


    public WebElement getDownloadBtn () {
        return driver.findElement(downloadBtn);
    }
    public WebElement getUploadBtn () {
        return driver.findElement(uploadBtn);
    }
    public WebElement getUplMessage () {
        return driver.findElement(uplMessage);
    }
}
