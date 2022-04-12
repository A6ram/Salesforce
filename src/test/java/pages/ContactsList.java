package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsList extends BasePage {

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Contacts']");
    public static final By NEW_CONTACT_BUTTON = By.cssSelector("a[title=New]");

    public ContactsList(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Opening contacts page")
    public void openPage() {
        driver.get("https://tms-d.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE);
    }

    @Step("Creating new contact")
    public void createNewContact() {
        driver.findElement(NEW_CONTACT_BUTTON).click();
    }
}
