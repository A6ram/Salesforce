package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.NavigationPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    LoginPage loginPage;
    NavigationPage salesNavigationMenuBarPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        salesNavigationMenuBarPage = new NavigationPage(driver);
    }

    @Step("Log in with: user - '{user}', password - '{password}'")
    public void login(String user, String password) {
        loginPage.openPage();
        assertTrue(loginPage.isPageOpened(), "Login page wasn't opened");
        loginPage.login(user, password);
    }
}
