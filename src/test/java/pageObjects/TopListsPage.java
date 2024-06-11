package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class TopListsPage extends BasePage {
    private static final String SumMenuList = "New Comments";
    public TopListsPage(WebDriver driver) {

        super(driver);
    }

    private List<WebElement> getColumnList() {
        return driver.findElements(By.xpath("//table[@id = 'category']//th"));
    }

    public boolean verifyColumnNamesList() {
        boolean result;
        String[] columnNames = new String[]{"#", "Language", "Author", "Date", "Comments", "Rate"};
//        List<String> names = new ArrayList<>(List.of("Gregor Scheithauer", "Oliver Schade", "Stefan Scheler"));
        List<String> names = Arrays.asList(columnNames);

        if (getColumnList().size() != names.size()) {
            return false;
        }

        for (int i = 0; i < names.size(); i++) {
            result = false;
            for (int j = 0; j < getColumnList().size(); j++) {
                if (getColumnList().get(i).getText().equals(names.get(j))) {
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
    private List<WebElement> getSubMenuList() {
        List<WebElement> elem = driver.findElements(By.xpath("//ul[@id = 'submenu']/li"));

        return elem;
    }
    public NewCommentsPage navigateToNewCommentsPage() {

        for (int i = 0; i < getSubMenuList().size(); i++) {
            if (getSubMenuList().get(i).getText().equalsIgnoreCase(SumMenuList)) {
                getSubMenuList().get(i).click();
            }
        }
        return new NewCommentsPage(driver);
    }
}


