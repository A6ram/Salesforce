package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final By USER_INFO_INPUT = By.id("username");
    public static final By PASSWORD_INFO_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы регистрации")
    public void openLoginPage() {
        driver.get(baseURL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
    }

    @Step("Логинимся '{user}' с паролем '{password}'")
    public void login(String user, String password) {
        driver.findElement(USER_INFO_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INFO_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

}
