package pages.FormsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeForm {

    public WebDriver driver;

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By maleBtn = By.className("custom-control-label");
    By femaleBtn = By.id("gender-radio-2");
    By otherBtn = By.id("gender-radio-3");
    By phone = By.id("userNumber");
    By birthDate = By.id("dateOfBirthInput");
    By subject = By.id("subjectsContainer");
    By hobby1 = By.id("hobbies-checkbox-1");
    By hobby2 = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label");
    By hobby3 = By.id("hobbies-checkbox-3");
    By datePicker = By.className("react-datepicker-popper");
    By uploadImg = By.id("uploadPicture");
    By currentAddress = By.id("currentAddress");
    By selectState = By.cssSelector(".css-19bqh2r");
    By selectCity = By.id("city");
    public WebElement getFirstName () {
        return driver.findElement(firstName);
    }
    public WebElement getLastName () {
        return driver.findElement(lastName);
    }
    public WebElement getEmail () {
        return driver.findElement(email);
    }
    public WebElement getMaleBtn () {
        return driver.findElement(maleBtn);
    }
    public WebElement getFemaleBtn () {
        return driver.findElement(femaleBtn);
    }
    public WebElement getOtherBtn () {
        return driver.findElement(otherBtn);
    }
    public WebElement getPhoneNmbr () {
        return driver.findElement(phone);
    }
    public WebElement getBirthDate () {
        return driver.findElement(birthDate);
    }
    public WebElement getSubject () {
        return driver.findElement(subject);
    }
    public WebElement getHobby1 () {
        return driver.findElement(hobby1);
    }
    public WebElement getHobby2 () {
        return driver.findElement(hobby2);
    }
    public WebElement getHobby3 () {
        return driver.findElement(hobby3);
    }
    public WebElement getDatePicker () {
        return driver.findElement(datePicker);
    }
    public WebElement getUploadImg () {
        return driver.findElement(uploadImg);
    }
    public WebElement getCurrentAddress () {
        return driver.findElement(currentAddress);
    }
    public WebElement getSelectState () {
        return driver.findElement(selectState);
    }
    public WebElement getSelectCity () {
        return driver.findElement(selectCity);
    }

 }
