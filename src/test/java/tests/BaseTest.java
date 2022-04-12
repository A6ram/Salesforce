package tests;

import dto.Account;
import dto.Contact;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;
import steps.AccountSteps;
import steps.ContactSteps;
import steps.LoginSteps;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    NavigationPage salesNavigationMenuBarPage;
    NewAccountModal newAccountModal;
    NewContactModal newContactModal;
    AccountList accountsListPage;
    AccountPage accountPage;
    ContactsList contactsListPage;
    ContactsPage contactPage;
    Account account;
    Contact contact;
    AccountSteps accountSteps;
    ContactSteps contactSteps;
    LoginSteps loginSteps;

    @Parameters({"browser"})
    @BeforeMethod(description = "Открытие браузера")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        salesNavigationMenuBarPage = new NavigationPage(driver);
        newAccountModal = new NewAccountModal(driver);
        newContactModal = new NewContactModal(driver);
        accountsListPage = new AccountList(driver);
        accountPage = new AccountPage(driver);
        contactsListPage = new ContactsList(driver);
        contactPage = new ContactsPage(driver);
        account = new Account("TeachMeSkills", "teachmeskills.by", "Analyst", "293795430",
                "291964066", "Father", "Apparel", "5", "100000", "Hello");
        contact = new Contact("Mr.", "Il", "Lia", "TeachMeSkills", "2222613",
                "Good boy", "Minsk");
        accountSteps = new AccountSteps(driver);
        contactSteps = new ContactSteps(driver);
        loginSteps = new LoginSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void close() {
        driver.quit();
    }
}
