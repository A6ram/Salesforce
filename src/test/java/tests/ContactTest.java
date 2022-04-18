package tests;

import dto.Contact;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest {

    @Test(description = "Test of creating new contact with all possible information filled in")
    public void newContactShouldBeCreated() {
        loginSteps.login("i.a6ram-4qqv@force.com", "pipikonda5");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Contact contact = Contact.builder()
                .salutation("Mr.")
                .firstName("Il")
                .lastName("Lia")
                .accountName("TMS")
                .phone("3795430")
                .description("Master")
                .mailingStreet("Minsk")
                .build();
        contactSteps.create(contact);
        assertTrue(contactPage.isPageOpened(), "Contact page wasn't opened");
        assertEquals(contactPage.getContactName(), "Mr. Il Lia", "Contact name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when necessary information wasn't filled in")
    public void errorMessageShouldBeDisplayedIfNecessaryInformationIsEmpty() {
        loginSteps.login("i.a6ram-4qqv@force.com", "pipikonda5");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Contact contact = Contact.builder()
                .salutation("Mr.")
                .firstName("Il")
                .lastName("")
                .accountName("TMS")
                .phone("3795430")
                .description("Master")
                .mailingStreet("Minsk")
                .build();
        contactSteps.create(contact);
        assertEquals(newContactModal.getErrorMessage(), "We hit a snag.",
                "Error message doesn't match or wasn't detected");
    }
}
//"i.a6ram-4qqv@force.com"
//"pipikonda5"