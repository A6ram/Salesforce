package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.NavigationPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogIn() {

        driver.get("https://universitetinformatikiiradioelektr.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("i.a6ram-4qqv@force.com");
        driver.findElement(By.id("password")).sendKeys("pipikonda5");
        driver.findElement(By.id("Login")).click();
        assertEquals(NavigationPage.getPageTitle(), "Sales", "Log in failed");
    }

}

//i.a6ram-4qqv@force.com  pipikonda5