package pageTests;

import enums.BrowserType;
import helpers.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

//    protected WebDriver driver;
//    @BeforeMethod
//    public void  starUp() {
//
//        driver = BrowserFactory.getDriver(BrowserType.CHROME);
//    }
//    @AfterMethod
//    public void tearDown()  {
//
//        driver.quit();
//    }


    //Sergey Demianenko

    protected WebDriver driver;

//        public BaseTest(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//    protected WebDriver getDriver() {
//        return driver;
//    }
    @BeforeMethod
    public void  starUp() {

//            getDriver(BrowserType.CHROME);
        driver = BrowserFactory.getDriver(BrowserType.CHROME);
    }
    @AfterMethod
    public void tearDown()  {

        driver.quit();
    }
}
