package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class NewAccountModal {
    public static final By SAVE = By.xpath("//div[contains(@class, 'modal-body')]//button[@title='Save']"); //By.cssSelector("[title=Save]");
    WebDriver driver;

    public NewAccountModal(WebDriver driver) {
        this.driver = driver;

    }

    @Step("Получение инфо об аккаунте")
    public void create(String accountName, String website, String type, String phone, String fax, String parentAccount,
                       String industry, String employees, String annualRevenue, String description) {
        new Input(driver, "Account Name", "Account").write(accountName);
        new Input(driver, "Website", "Account").write(website);
        new DropDown(driver, "Type", "Account").select(type);
        new Input(driver, "Phone", "Account").write(phone);
        new Input(driver, "Fax", "Account").write(fax);
        new Input(driver, "Parent Account", "Account").write(parentAccount);
        new DropDown(driver, "Industry", "Account").select(industry);
        new Input(driver, "Employees", "Account").write(employees);
        new Input(driver, "Annual Revenue", "Account").write(annualRevenue);
        new TextArea(driver, "Description", "Account").write(description);
    }

    @Step("Сохранение аккаунта")
    public void save() {
        driver.findElement(SAVE).click();
    }

}
