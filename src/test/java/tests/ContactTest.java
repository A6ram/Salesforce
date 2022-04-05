package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactTest extends BaseTest {
    @Test(description = "Test of creating new contact with all possible information filled in")
    public void newContactCreated() {
        loginPage.openLoginPage();
        loginPage.login("i.a6ram-4qqv@force.com", "pipikonda5");
        contactsPage.openContactsPage();
        contactsPage.createNewContact();
        newContactModal.create("Mr.", "Il", "Lia", "TMS", "3795430", "QA", "Minsk");
        newContactModal.save();
        assertEquals(contactsPage.getPageTitle(), "Contact", "Page title doesn't match");
        assertEquals(contactsPage.getContactName(), "Mr.Il Lia", "Contact name doesn't match");
    }
}
