package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactsPage extends BasePage {

    public static final By PAGE_TITLE2 = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By CONTACT_NAME = By.xpath("//div[contains(@class, 'entityNameTitle')]/..//span[contains(@class, 'custom-truncate')]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE2);
    }

    @Step("Получение заголовка")
    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE2).getText();
    }

    @Step("Получение 'account name' ")
    public String getContactName() {
        return driver.findElement(CONTACT_NAME).getText();
    }
}
