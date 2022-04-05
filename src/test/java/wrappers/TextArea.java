package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;
    String type;

    public TextArea(WebDriver driver, String label, String type) {
        this.driver = driver;
        this.label = label;
        this.type = type;
    }

    public void write(String text) {
        driver.findElement(By.xpath
                (String.format("//div[contains(@class, 'modal-body')]//span[text()='%s']/" +
                        "ancestor::div[contains(@class, 'uiInputTextArea ')]//textarea", label))).sendKeys(text);
    }
}
