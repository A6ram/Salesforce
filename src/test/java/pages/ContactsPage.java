package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage {
    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Contacts']");
    public static final By NEW_CONTACT_BUTTON = By.cssSelector("a[title=New]");
    public static final By PAGE_TITLE2 = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By CONTACT_NAME = By.xpath("//div[contains(@class, 'entityNameTitle')]/..//span[contains(@class, 'custom-truncate')]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие вкладки 'Contacts'")
    public void openContactsPage() {
        driver.get("https://tms-d.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    @Step("Создание нового контакта")
    public void createNewContact() {
        driver.findElement(NEW_CONTACT_BUTTON).click();
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
