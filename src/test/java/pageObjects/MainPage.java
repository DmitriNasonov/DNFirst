package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class MainPage extends BasePage {

    private static final String PageTitle = "99 Bottles of Beer";

    private static final String SubNewLanguage = "SUBMIT NEW LANGUAGE";

    private static final String TopList = "Top Lists";

    @FindBy(xpath = ("//ul[@id='menu']/li/a"))
    private List<WebElement> mainMenuList;

    public MainPage(WebDriver driver) {

        super(driver);
    }

    public void openBasePage() {

        driver.get("http://www.99-bottles-of-beer.net/");
    }

    private WebElement getTitle() {

        return driver.findElement(By.xpath("//h1[text() = '" + PageTitle + "']"));
    }

    public boolean verifyTitle() {

        return getTitle().getText().equals(PageTitle);
    }

    private WebElement getMenuName() {

        return driver.findElement(By.xpath("//ul[@id='menu']/li/a"));
    }

    private List<WebElement> getMainMenuList() {
        List<WebElement> elem = driver.findElements(By.xpath("//ul[@id='menu']/li/a"));
//        System.out.println(elem.size());
        return elem;
    }

    public String subNewLanList(String tabName) {
//        logger.debug("Tabs name ->"+tabName );
        String name = "";
        List<WebElement> elements = driver.findElements(
                By.xpath("//ul[@id='menu']//a"));
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(tabName)) {
                name = tabName;
            }

        }
        return name;
    }

    public boolean verifyLastMenuItem() {

        return getMainMenuList().get(getMainMenuList().size() - 1).getText().equalsIgnoreCase(SubNewLanguage);
    }

    //test3
    public SubmitNewLanguagePage navigateToSubmitLanguagePage() {

        for (int i = 0; i < getMainMenuList().size(); i++) {
            if (getMainMenuList().get(i).getText().equalsIgnoreCase(SubNewLanguage)) {
                getMainMenuList().get(i).click();
            }
        }
        return new SubmitNewLanguagePage(driver);
    }

    public BrowserLanguagePage navigateToBrowserLanguage() {

        for (int i = 0; i < getMainMenuList().size(); i++) {
            if (getMainMenuList().get(i).getText().equalsIgnoreCase("Browse Languages")) {
                getMainMenuList().get(i).click();
                return new BrowserLanguagePage(driver);
            }
        }
        return null;
    }

    private List<WebElement> getSubMenuStartPage() {
        List<WebElement> elem = driver.findElements(By.xpath("//ul[@id='submenu']/li"));
        return elem;
    }

    public void navigateToSubMenuStar(String subItemMenuName) {
        for (int i = 0; i < getSubMenuStartPage().size(); i++) {
            if (getSubMenuStartPage().get(i).getText().equalsIgnoreCase(subItemMenuName)) {
                getSubMenuStartPage().get(i).click();

            }

        }

    }

    private List<WebElement> getCreatorList() {

        return driver.findElements(By.xpath("//div[@id='main']/h3"));
    }

    public boolean verifyCreatorsNamesList() {
        boolean result;
        String[] creatorsNames = new String[]{"Gregor Scheithauer", "Oliver Schade", "Stefan Scheler"};
//        List<String> names = new ArrayList<>(List.of("Gregor Scheithauer", "Oliver Schade", "Stefan Scheler"));
        List<String> names = Arrays.asList(creatorsNames);

        if (getCreatorList().size() != names.size()) {
            return false;
        }

        for (int i = 0; i < names.size(); i++) {
            result = false;
            for (int j = 0; j < getCreatorList().size(); j++) {
                if (getCreatorList().get(i).getText().equals(names.get(j))) {
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

    public TopListsPage navigateToTopListsPage() {
        for (int i = 0; i < getMainMenuList().size(); i++) {
            if (getMainMenuList().get(i).getText().equalsIgnoreCase(TopList)) {
                getMainMenuList().get(i).click();
            }
        }
        return new TopListsPage(driver);
    }
}

//Sergey Demianenko
//    public void openBasePage() {
//
//        getDriver().get("http://www.99-bottles-of-beer.net/");
//
//    }
//    private List<WebElement> getMainMenuList() {
//
//       return mainMenuList;
//    }
//    public SubmitNewLanguagePage navigateToSubmitLanguagePage() {
//
//        for (int i = 0; i < getMainMenuList().size(); i++) {
//            if (getMainMenuList().get(i).getText().equalsIgnoreCase(SubNewLanguage)) {
//                getMainMenuList().get(i).click();
//            }
//        }
//        return new SubmitNewLanguagePage(getDriver());
//    }
//}


