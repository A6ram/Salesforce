package tests;

import dto.Account;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AccountTest extends BaseTest {

    @Test(description = "Test of creating new account with all possible information filled in")
    public void newAccountShouldBeCreated() {
        loginSteps.login("i.a6ram-4qqv@force.com", "pipikonda5");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Account account = Account.builder()
                .accountName("TMS")
                .website("teachmeskills.by")
                .type("Analyst")
                .phone("293795430")
                .fax("293795430")
                .parentAccount("Father")
                .industry("Apparel")
                .employees("5")
                .annualRevenue("100000")
                .description("Hello")
                .build();
        accountSteps.create(account);
        assertTrue(accountPage.isPageOpened(), "Account page wasn't opened");
        assertEquals(accountPage.getAccountName(), "TMS", "Account name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when account name wasn't filled in")
    public void errorMessageShouldBeDisplayedIfAccountNameIsEmpty() {
        loginSteps.login("i.a6ram-4qqv@force.com", "pipikonda5");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Account account = Account.builder()
                .accountName("")
                .website("teachmeskills.by")
                .type("Analyst")
                .phone("293795430")
                .fax("293795430")
                .parentAccount("Father")
                .industry("Apparel")
                .employees("5")
                .annualRevenue("100000")
                .description("Hello")
                .build();
        accountSteps.create(account);
        assertEquals(newAccountModal.getErrorMessage(), "These required fields must be completed: Account Name",
                "Error doesn't match or wasn't detected");
    }
}
//"i.a6ram-4qqv@force.com"
//"pipikonda5"