package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    NewAccountModal newAccountModal;
    NewContactModal newContactModal;
    LoginPage loginPage;
    ContactsPage contactsPage;
    AccountPage accountPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Открытие браузера")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void close() {
        driver.quit();
    }
}
