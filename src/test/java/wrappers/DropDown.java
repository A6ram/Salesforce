package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String label;
    String type;

    public DropDown(WebDriver driver, String label, String type) {
        this.driver = driver;
        this.label = label;
        this.type = type;
    }

    public void select(String option) {
        driver.findElement(By.xpath(
                String.format("//span[text()=%s]/ancestor::div[contains(@class, 'uiInput')]//a", label)
        )).click();
        driver.findElement(By.cssSelector(String.format("a[title=%s]", option))).click();
    }
}
