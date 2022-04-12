package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    public static final By TITLE = By.xpath("//div[contains(@class, 'slds-context-bar')]//span[text()='Sales']");

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(TITLE);
    }
    @Step("Обнаружение заголовка")
    public static String getPageTitle() {
        return driver.findElement(TITLE).getText();
    }
}
