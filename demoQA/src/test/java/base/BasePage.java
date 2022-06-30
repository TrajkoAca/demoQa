package base;

import pages.FormsPage.PracticeForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pages.BookstorePages.Login;
import pages.BookstorePages.Profile;
import pages.ElementsPages.*;

import java.time.Duration;

public class BasePage {
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdWait;
    public Elements elementsPage;
    public Forms formsPage;
    public BookStoreApp bookStoreAppPage;
    public TextBox textBoxPage;
    public CheckBox checkBoxPage;
    public RadioButton radioButtonPage;
    public Buttons buttonsPage;
    public PracticeForm practiceFormPage;
    public Login loginPage;
    public Profile profilePage;
    public WebTables webTablesPage;
    public Links linksPage;
    public UploadAndDownload uplAndDwnPages;
    public DynProperties dynPropertiesPage;
    public AlertsFramesWindows alertsFramesWindowsPage;

    @BeforeClass
    public void beforeClass () {
        wdm = new ChromeDriverManager();
        wdm.setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        elementsPage = new Elements(driver, wdWait);
        formsPage = new Forms(driver, wdWait);
        bookStoreAppPage = new BookStoreApp(driver, wdWait);
        textBoxPage = new TextBox(driver, wdWait);
        checkBoxPage = new CheckBox(driver, wdWait);
        radioButtonPage = new RadioButton(driver,wdWait);
        buttonsPage = new Buttons(driver);
        practiceFormPage = new PracticeForm(driver);
        loginPage = new Login(driver,wdWait);
        profilePage = new Profile(driver,wdWait);
        webTablesPage = new WebTables(driver,wdWait);
        linksPage = new Links(driver, wdWait);
        uplAndDwnPages = new UploadAndDownload(driver, wdWait);
        dynPropertiesPage = new DynProperties(driver, wdWait);
        alertsFramesWindowsPage = new AlertsFramesWindows(driver, wdWait);
    }
}
