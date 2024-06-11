package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(200));
    }
}

//Sergey Demianenko
//public abstract class BasePage {
//    private final WebDriver driver;
//    private WebDriverWait wait2;
//
//    private WebDriverWait wait5;
//
//    private WebDriverWait wait10;
//
//    private WebDriverWait wait60;
//
//
//    public BasePage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//    protected WebDriver getDriver() {
//        return driver;
//    }
//
//    protected WebDriverWait getWait2() {
//        if (wait2 == null) {
//            wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
//        }
//
//        return wait2;
//    }
//
//    protected WebDriverWait getWait5() {
//        if (wait5 == null) {
//            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
//        }
//
//        return wait5;
//    }
//
//    protected WebDriverWait getWait10() {
//        if (wait10 == null) {
//            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        }
//
//        return wait10;
//    }
//
//    protected WebDriverWait getWait60() {
//        if (wait60 == null) {
//            wait60 = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
//        }
//
//        return wait60;
//    }
//}