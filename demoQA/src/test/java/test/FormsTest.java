package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class FormsTest extends BasePage {


    @BeforeMethod
    public void setUp() {
        driver.navigate().to("https://demoqa.com/forms");
        driver.manage().window().maximize();
    }

    @Test
    public void practiceFormsOpened () {
        formsPage.getPracticeForm().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/automation-practice-form");
    }

    @Test
    public void nameInputs () {
        practiceFormsOpened();
        WebElement name = practiceFormPage.getFirstName();
        name.sendKeys("Aca");
        WebElement lastName = practiceFormPage.getLastName();
        lastName.sendKeys("Traj");
        Assert.assertEquals(name.getAttribute("value"), "Aca");
        Assert.assertEquals(lastName.getAttribute("value"), "Traj");
    }
    @Test
    public void emailInput () {
        practiceFormsOpened();
        WebElement mail = practiceFormPage.getEmail();
        mail.sendKeys("aca@aca.com");
        Assert.assertEquals(mail.getAttribute("value"), "aca@aca.com");
    }
    @Test
    public void maleBtnClick () {
        practiceFormsOpened();
        WebElement mbtn = practiceFormPage.getMaleBtn();
        if (!mbtn.isSelected()) {
            mbtn.click();
        }
    }

    @Test
    public void genderBtnsChoice () {
        practiceFormsOpened();
        List<WebElement> rbtns = driver.findElements(By.className("custom-control-label"));
        WebElement first = rbtns.get(0);
        for (int i = 0; i < rbtns.size(); i++) {
            if (!rbtns.get(i).isSelected()){
                first.click();
            }
        }
    }
    @Test
    public void changeGenderChoice () {
        maleBtnClick();
        List<WebElement> rbtns = driver.findElements(By.className("custom-control-label"));
        WebElement second = rbtns.get(1);
        second.click();
    }

    @Test
    public void phoneNmbrInput () {
        practiceFormsOpened();
        WebElement phone = practiceFormPage.getPhoneNmbr();
        phone.sendKeys("1234567891");
        Assert.assertEquals(phone.getAttribute("value"), "1234567891");
    }

    @Test
    public void datePickerPop () {
        practiceFormsOpened();
        WebElement date = practiceFormPage.getBirthDate();
        date.click();
        WebElement datePicker = practiceFormPage.getDatePicker();
        Assert.assertTrue(datePicker.isDisplayed());
    }

    @Test
    public void dateOfBirthInput () {
        datePickerPop();
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        month.click();
        Select s = new Select(month);
        s.selectByIndex(4);

        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        year.click();
        WebElement yearSelect = driver.findElement(By.cssSelector("option[value='1988']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", yearSelect);
        yearSelect.click();

        WebElement daySelect = driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--016"));
        daySelect.click();

        WebElement birthData = driver.findElement(By.id("dateOfBirthInput"));
        String str = birthData.getAttribute("value");
        //System.out.println(str);
        String[] niz = str.split("\\s");
        //System.out.println(niz[0]);
        Assert.assertEquals(niz[0], "16");
        Assert.assertEquals(niz[1], "May");
        Assert.assertEquals(niz[2], "1988");
    }
    @Test
    public void subjectInput () {
        practiceFormsOpened();
        WebElement subjectField = practiceFormPage.getSubject();
        subjectField.click();
        WebElement inputText = driver.findElement(By.id("subjectsInput"));
        inputText.sendKeys("m");
        inputText.sendKeys(Keys.ENTER);
        inputText.sendKeys("c");
        inputText.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
        inputText.sendKeys(Keys.ENTER);

        WebElement resultBox1 = driver.findElement(By.cssSelector(".css-12jo7m5.subjects-auto-complete__multi-value__label"));
        WebElement resultBox2 = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]/div[2]/div[1]"));
        String s1 = resultBox1.getText();
        String s2 = resultBox2.getText();
        //System.out.println(s1);
        //System.out.println(s2);
        Assert.assertEquals(s1, "Maths");
        Assert.assertEquals(s2, "Computer Science");
    }

    @Test
    public void hobbyCheck () {
        practiceFormsOpened();
        WebElement klik = practiceFormPage.getHobby2();
        boolean isSelected = klik.isSelected();
        if (!isSelected) {
            klik.click();
        }
    }

    @Test
    public void uploadPic () {
        practiceFormsOpened();
        WebElement uplBtn = practiceFormPage.getUploadImg();
        uplBtn.sendKeys("E:\\slika za ITBootcamp\\MOG.png");
    }

    @Test
    public void addressStateAndCityInput () {
        practiceFormsOpened();
        WebElement addressInput = practiceFormPage.getCurrentAddress();
        addressInput.click();
        addressInput.sendKeys("Jovana Cirilova");
        addressInput.sendKeys(Keys.TAB);
        WebElement state = practiceFormPage.getSelectState();
        state.click();
        WebElement stateChoice = driver.findElement(By.id("react-select-3-input"));
        stateChoice.sendKeys("Raja");
        stateChoice.sendKeys(Keys.TAB);
        WebElement city = practiceFormPage.getSelectCity();
        city.click();
        WebElement cityChoice = driver.findElement(By.id("react-select-4-input"));      //  <---
        cityChoice.sendKeys("Jai");
        cityChoice.sendKeys(Keys.TAB);
        cityChoice.submit();
    }

    @Test
    public void fillForm () {
        practiceFormsOpened();
        nameInputs();
        emailInput();
        genderBtnsChoice();
        phoneNmbrInput();
        dateOfBirthInput();
        subjectInput();
        hobbyCheck();
        uploadPic();
        addressStateAndCityInput();

        WebElement modal = driver.findElement(By.className("modal-content"));
        WebElement modalHeader = modal.findElement(By.id("example-modal-sizes-title-lg"));
        WebElement modalBtn = modal.findElement(By.id("closeLargeModal"));
        String s = modalHeader.getText();
        modalBtn.click();
        //System.out.println(s);

        Assert.assertEquals(s,"Thanks for submitting the form");
    }
}

