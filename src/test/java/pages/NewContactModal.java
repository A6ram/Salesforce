package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class NewContactModal {
    public static final By SAVE = By.xpath("//div[contains(@class, 'modal-body')]//button[@name='SaveEdit']");
    WebDriver driver;

    public NewContactModal(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение информации о контакте")
    public void create(String salutation, String firstName, String lastName, String accountName,
                       String phone, String description, String mailingStreet) {
        new DropDown(driver, "Salutation", "Contact").select(salutation);
        new Input(driver, "First Name", "Contact").write(firstName);
        new Input(driver, "Last Name", "Contact").write(lastName);
        new Input(driver, "Account Name", "Contact").writeAndClick(accountName);
        new Input(driver, "Phone", "Contact").write(phone);
        new TextArea(driver, "Description", "Contact").write(description);
        new TextArea(driver, "Mailing Street", "Contact").write(mailingStreet);
    }

    @Step("Сохранение аккаунта")
    public void save() {
        driver.findElement(SAVE).click();
    }
}
