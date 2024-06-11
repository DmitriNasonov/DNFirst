package pageTests;

import pageObjects.BrowserLanguagePage;
import pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBrowserLanguage extends BaseTest{
    @Test
    public void testFirstItemZeroNine(){
        MainPage mainPage= new MainPage(driver);
        mainPage.openBasePage();
        BrowserLanguagePage browserLanguagePage= mainPage.navigateToBrowserLanguage();
        Assert.assertTrue(browserLanguagePage.verifyFirstMenuZeroNine());
    }

//  Task# 11-14
    @Test
    public void testColumnName(){
        MainPage mainPage= new MainPage(driver);
        mainPage.openBasePage();
        BrowserLanguagePage browserLanguagePage= mainPage.navigateToBrowserLanguage();
        Assert.assertTrue(browserLanguagePage.verifyColumnName());
    }
    // Second decision task# 11-14
    @Test
    public void testFirstItem(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        BrowserLanguagePage browseLanguagesPage = mainPage.navigateToBrowserLanguage();
        Assert.assertTrue(browseLanguagesPage.verifyTableHeaders(1,"Language"));
        Assert.assertTrue(browseLanguagesPage.verifyTableHeaders(2,"Author"));
    }

    @Test
    public void testFirstHeaderItem() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        BrowserLanguagePage browseLanguagePage = mainPage.navigateToBrowserLanguage();
        Assert.assertEquals(browseLanguagePage.getTableHeadersById(1), "Language");
    }

    @Test
    public void testSecondHeaderItem() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        BrowserLanguagePage browseLanguagesPage = mainPage.navigateToBrowserLanguage();
        Assert.assertEquals(browseLanguagesPage.getTableHeadersById(2), "Author");
    }

}
