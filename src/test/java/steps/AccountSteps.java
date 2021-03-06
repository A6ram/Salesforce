package steps;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.AccountList;
import pages.NewAccountModal;

import static org.testng.Assert.assertTrue;

@Log4j2
public class AccountSteps {

    AccountList accountsListPage;
    NewAccountModal newAccountModal;

    public AccountSteps(WebDriver driver) {
        accountsListPage = new AccountList(driver);
        newAccountModal = new NewAccountModal(driver);
    }

    @Step("Creation of new account: '{account.accountName}'")
    public void create(Account account) {
        log.info("Creation of new account '{}'", account.getAccountName());
        accountsListPage.openPage();
        assertTrue(accountsListPage.isPageOpened(), "Accounts list page wasn't opened");
        accountsListPage.createNewAccount();
        assertTrue(newAccountModal.isPageOpened(), "Modal of account creation wasn't opened");
        newAccountModal.fillInAccountInformation(account);
        newAccountModal.save();
    }
}
