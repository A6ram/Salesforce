package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogIn() {
        loginSteps.login("i.a6ram-4qqv@force.com", "pipikonda5");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
    }
}

//i.a6ram-4qqv@force.com  pipikonda5