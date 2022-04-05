package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AccountTest extends BaseTest {
    @Test(description = "Test of creating new account with all possible information filled in")
    public void newAccountShouldBeCreated() {
        loginPage.openLoginPage();
        loginPage.login("i.a6ram-4qqv@force.com", "pipikonda5");
        accountPage.openAccountsPage();
        accountPage.createNewAccount();
        newAccountModal.create("TMS", "teachmeskills.by", "Analyst", "293795430",
                "297070203", "Father", "Apparel", "3", "100", "Shalom");
        newAccountModal.save();
        assertEquals(accountPage.getPageTitle(), "Account", "Page title doesn't match");
        assertEquals(accountPage.getAccountName(), "TMS", "Account name doesn't match");
    }
}
