package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class BrowserLanguagePage extends BasePage {

    public BrowserLanguagePage(WebDriver driver) {
        super(driver);

    }

    private List<WebElement> getSubMenuList() {

        return driver.findElements(By.xpath("//ul[@id='submenu']/li/a"));
    }


    public boolean verifyFirstMenuZeroNine() {
        return getSubMenuList().get(0).getText().equals("0-9");

    }

    private List<WebElement> getColumnNameList() {

        return driver.findElements(By.xpath("//table[@id='category']/tbody/tr/th"));
    }

    public boolean verifyColumnName() {
        boolean result;
        String[] columnName = new String[]{"Language", "Author"};
        List<String> names = Arrays.asList(columnName);

        for (int i = 0; i < 1; i++) {
            result = false;
            for (int j = 0; j < 1; j++) {
                if (getColumnNameList().get(i).getText().equals(names.get(j))) {
                    result = true;
                    break;
                }

            }
            if (!result) {
                return false;
            }

        }
        return true;
    }
    // Second decision task# 11-14
    private List<WebElement> getTableHeadersList(){
        return driver.findElements(By.xpath("//table[@id='category']//tr/th"));
    }
    public  boolean verifyTableHeaders(int headerId, String headerName) {
        if (headerId > 0 && headerId < getTableHeadersList().size()) {
            return getTableHeadersList().get(headerId - 1).getText().equals(headerName);
        }
        return false;
    }

    public String getTableHeadersById(int headerId) {
        if (headerId > 0 && headerId < getTableHeadersList().size()) {
            return getTableHeadersList().get(headerId - 1).getText();
        }
        return null;
    }
}
