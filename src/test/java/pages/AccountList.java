package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountList extends BasePage {
    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Accounts']");
    public static final By NEW_ACCOUNT_BUTTON = By.cssSelector("a[title=New]");

    public AccountList(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Opening accounts page")
    public void openPage() {
        log.info("Opening accounts page");
        driver.get("https://tms-d.lightning.force.com/lightning/o/Account/list?filterName=Recent");
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE);
    }

    @Step("Creating new account")
    public void createNewAccount() {
        log.info("Opening New Account Modal page");
        driver.findElement(NEW_ACCOUNT_BUTTON).click();
    }
}