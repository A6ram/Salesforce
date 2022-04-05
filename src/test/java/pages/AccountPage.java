package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By ACCOUNT_NAME = By.xpath("//div[contains(@class, 'entityNameTitle')]/..//lightning-formatted-text");
    public static final By PAGE_TITLE2 = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Accounts']");
    public static final By NEW_ACCOUNT_BUTTON = By.cssSelector("a[title=New]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting page title")
    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Getting account name")
    public String getAccountName() {
        return driver.findElement(ACCOUNT_NAME).getText();
    }

    @Step("Opening accounts page")
    public void openAccountsPage() {
        driver.get("https://tms-d.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    @Step("Creating new account")
    public void createNewAccount() {
        driver.findElement(NEW_ACCOUNT_BUTTON).click();
    }
}
