package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class NewCommentsPage extends BasePage {

    public NewCommentsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyComments() {
        return driver.findElements(By.xpath("//div[@id = 'main']")).isEmpty();
    }

}
