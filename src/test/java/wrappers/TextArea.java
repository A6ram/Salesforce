package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("Writing {} into {}", text, label);
        if (type.equalsIgnoreCase("Account")) {
            driver.findElement(By.xpath
                    (String.format("//div[contains(@class, 'modal-body')]//span[text()='%s']/" +
                            "ancestor::div[contains(@class, 'uiInputTextArea ')]//textarea", label))).sendKeys(text);
        } else if (type.equalsIgnoreCase("Contact")) {
            driver.findElement(By.xpath
                    (String.format("//div[contains(@class, 'modal-body')]//label[text()='%s']/..//textarea", label))).sendKeys(text);
        }
    }
}
