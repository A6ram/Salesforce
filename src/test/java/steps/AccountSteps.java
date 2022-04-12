package steps;

import dto.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AccountList;
import pages.NewAccountModal;

import static org.testng.Assert.assertTrue;

public class AccountSteps {
    AccountList accountsListPage;
    NewAccountModal newAccountModal;

    public AccountSteps(WebDriver driver) {
        accountsListPage = new AccountList(driver);
        newAccountModal = new NewAccountModal(driver);
    }

    @Step("Creation of new account: '{account.accountName}'")
    public void create(Account account) {
        accountsListPage.openPage();
        assertTrue(accountsListPage.isPageOpened(), "Accounts list page wasn't opened");
        accountsListPage.createNewAccount();
        assertTrue(newAccountModal.isPageOpened(), "Modal of account creation wasn't opened");
        newAccountModal.fillInAccountInformation(account);
        newAccountModal.save();
    }
}
