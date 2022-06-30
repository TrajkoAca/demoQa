package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ElementsTest extends BasePage {

    @BeforeMethod
    public void setUp() {
        driver.navigate().to("https://demoqa.com/elements");
        driver.manage().window().maximize();
    }

    @Test
    public void textBoxPageOpened() {
        elementsPage.getTextBox().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/text-box");
    }

    @Test
    public void textBoxInput() {
        textBoxPageOpened();
        textBoxPage.getFullName().sendKeys("Aca");
        textBoxPage.getEmail().sendKeys("a@gmail.com");
        textBoxPage.getCurrentAddress().sendKeys("Igmanska");
        textBoxPage.getPermAddress().sendKeys("Igmanska");
        textBoxPage.getSubmitButton().click();
        Assert.assertTrue(textBoxPage.getOutput().isDisplayed());
    }

    @Test
    public void checkBoxOpened() {
        elementsPage.getCheckBox().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/checkbox");
    }

    @Test
    public void checkElClickable() {
        checkBoxOpened();
        WebElement klik = checkBoxPage.getCheckBoxBtn();
        boolean isSelected = klik.isSelected();
        if (!isSelected) {
            klik.click();
        }
        WebElement message = driver.findElement(By.id("result"));
        if (isSelected) {
            Assert.assertTrue(message.isDisplayed());
        }
    }

    @Test
    public void expandAllBtnClickable() {
        checkBoxOpened();
        WebElement klik = checkBoxPage.getExpandAllBtn();
        wdWait.until(ExpectedConditions.elementToBeClickable(klik));
        klik.click();
        WebElement expandedNode = driver.findElement(By.cssSelector(".rct-node.rct-node-parent.rct-node-expanded"));
        Assert.assertTrue(expandedNode.isDisplayed());
    }


    @Test
    public void collapseAllBtnClickable() {
        expandAllBtnClickable();
        WebElement klik = checkBoxPage.getCollapseBtn();
        klik.click();
    }

    @Test
    public void radioBtnOpened() {
        elementsPage.getRadioButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/radio-button");
    }

    @Test
    public void clickYes() {
        radioBtnOpened();
        WebElement klik = radioButtonPage.getYesBtn();
        boolean isSelected = klik.isSelected();
        if (!isSelected) {
            klik.click();
        }
        WebElement el = radioButtonPage.getTextYes();
        Assert.assertTrue(el.isDisplayed());
        Assert.assertEquals(el.getText(), "You have selected Yes");
    }
    @Test
    public void clickImpressive () {
        radioBtnOpened();
        WebElement klik = radioButtonPage.getImpressiveBtn();
        boolean isSelected = klik.isSelected();
        if (!isSelected) {
            klik.click();
        }
        WebElement el = radioButtonPage.getTextImpressive();
        Assert.assertTrue(el.isDisplayed());
        Assert.assertEquals(el.getText(), "You have selected Impressive");
    }

    @Test
    public void cannotClikNo () {
        radioBtnOpened();
        WebElement klik = radioButtonPage.getNoBtn();
        klik.click();
        Assert.assertFalse(klik.isSelected());
    }

    @Test
    public void buttonsOpened () {
        elementsPage.getButtons().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/buttons");
    }

    @Test
    public void allButtonsClick () throws InterruptedException {
        buttonsOpened();
        Actions a = new Actions(driver);
        WebElement dClick = buttonsPage.getDoubleClick();
        a.moveToElement(dClick).doubleClick().perform();

        WebElement rClick = buttonsPage.getRightClick();
        a.moveToElement(rClick).contextClick().perform();

        WebElement click = buttonsPage.getClick();
        a.moveToElement(click);
        Thread.sleep(3000);
        click.click();

        WebElement dc = buttonsPage.getDoubleClickMsg();
        WebElement rc = buttonsPage.getRightClickMsg();
        WebElement dync = buttonsPage.getDynamicClickMsg();
        Assert.assertEquals(dc.getText(), "You have done a double click");
        Assert.assertEquals(rc.getText(), "You have done a right click");
        Assert.assertEquals(dync.getText(), "You have done a dynamic click");
    }

    @Test
    public void webTablesOpened () {
        elementsPage.getWebTables().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/webtables");
    }

    @Test
    public void rowData () {
        webTablesOpened();
        for (int i = 0; i < webTablesPage.rowsCount(); i++) {
            String data = webTablesPage.rows().get(i).getText();
            System.out.print(data);
        }
    }
    @Test
    public void linksOpened () {
        elementsPage.getLinks().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/links");
    }


    @Test
    public void download () throws InterruptedException {
        driver.navigate().to("https://demoqa.com/upload-download");
        WebElement btn = uplAndDwnPages.getDownloadBtn();
        Thread.sleep(2000);
        btn.click();
    }
    @Test
    public void upload () {
        driver.navigate().to("https://demoqa.com/upload-download");
        WebElement btn = uplAndDwnPages.getUploadBtn();
        btn.sendKeys("C:\\Users\\Trajkocomi\\Downloads\\sampleFile.jpeg");
        String s = uplAndDwnPages.getUplMessage().getText();
        Assert.assertEquals(s, "C:\\fakepath\\sampleFile.jpeg");
    }

    @Test
    public void dynamicPropOpened () {
        WebElement url = elementsPage.getDynamicProp();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", url);
        url.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/dynamic-properties");
    }

    @Test
    public void afterFiveSecClick () {
        dynamicPropOpened();
        wdWait.until(ExpectedConditions.elementToBeClickable(dynPropertiesPage.getEnableAfterBtn())).click();
    }
    @Test
    public void colorChangeClick () {
        dynamicPropOpened();
        WebElement we = dynPropertiesPage.getColorChangeBtn();
        we.click();
    }
    @Test
    public void clickWhenVisible () {
        dynamicPropOpened();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter"))).click();
    }
    @Test
    public void simpleLink () {
        linksOpened();
        WebElement we = linksPage.allLinks().get(1);
        String str = we.getAttribute("href");
        we.click();
        Assert.assertEquals(str, driver.getCurrentUrl());
    }
    @Test
    public void dynamicLink () {
        linksOpened();
        WebElement we = linksPage.allLinks().get(2);
        String str = we.getAttribute("href");
        we.click();
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
        alertsFramesWindowsPage.switchToTab();
        Assert.assertEquals(str, driver.getCurrentUrl());
    }
    @Test
    public void linkCreated () throws InterruptedException {
        linksOpened();
        WebElement we = linksPage.allLinks().get(4);
        String str = "Link has responded with staus 201 and status text Created";
        we.click();
        Thread.sleep(500);
        String msg = linksPage.getLinkResponse().getText();
        //System.out.println(msg);
        Assert.assertEquals(str,msg);
    }
    @Test
    public void linkNoContent () throws InterruptedException {
        linksOpened();
        WebElement we = linksPage.allLinks().get(5);
        String str = "Link has responded with staus 204 and status text No Content";
        we.click();
        Thread.sleep(500);
        String msg = linksPage.getLinkResponse().getText();
        System.out.println(msg);
        Assert.assertEquals(str,msg);
    }
    @Test
    public void linkPermaMoved () throws InterruptedException {
        linksOpened();
        WebElement we = linksPage.allLinks().get(6);
        String str = "Link has responded with staus 301 and status text Moved Permanently";
        we.click();
        Thread.sleep(500);
        String msg = linksPage.getLinkResponse().getText();
        System.out.println(msg);
        Assert.assertEquals(str,msg);
    }
    @Test
    public void linkBadRequest () throws InterruptedException {
        linksOpened();
        WebElement we = linksPage.allLinks().get(7);
        String str = "Link has responded with staus 400 and status text Bad Request";
        we.click();
        Thread.sleep(500);
        String msg = linksPage.getLinkResponse().getText();
        System.out.println(msg);
        Assert.assertEquals(str,msg);
    }
    @Test
    public void linkUnauthorized () throws InterruptedException {
        linksOpened();
        WebElement we = linksPage.allLinks().get(8);
        String str = "Link has responded with staus 401 and status text Unauthorized";
        we.click();
        Thread.sleep(500);
        String msg = linksPage.getLinkResponse().getText();
        System.out.println(msg);
        Assert.assertEquals(str,msg);
    }
    @Test
    public void linkForbidden () throws InterruptedException {
        linksOpened();
        WebElement we = linksPage.allLinks().get(9);
        String str = "Link has responded with staus 403 and status text Forbidden";
        we.click();
        Thread.sleep(500);
        String msg = linksPage.getLinkResponse().getText();
        System.out.println(msg);
        Assert.assertEquals(str,msg);
    }
    @Test
    public void linkNotFound () throws InterruptedException {
        linksOpened();
        WebElement we = linksPage.allLinks().get(10);
        String str = "Link has responded with staus 404 and status text Not Found";
        we.click();
        Thread.sleep(500);
        String msg = linksPage.getLinkResponse().getText();
        System.out.println(msg);
        Assert.assertEquals(str,msg);
    }

}