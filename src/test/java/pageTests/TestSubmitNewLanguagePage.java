package pageTests;

import pageObjects.MainPage;
import pageObjects.SubmitNewLanguagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSubmitNewLanguagePage extends BaseTest {
    @Test
    public void testFirstSubmenuItem() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        SubmitNewLanguagePage submitNewLanguagePage = mainPage.navigateToSubmitLanguagePage();

        Assert.assertTrue(submitNewLanguagePage.verifySubMenuItem());
    }

    @Test
    public void testErrorMessage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        SubmitNewLanguagePage submitNewLanguagePage = mainPage.navigateToSubmitLanguagePage();
        submitNewLanguagePage.submitLanguageButton();

        Assert.assertEquals(true, submitNewLanguagePage.verifyErrorMessage());
    }

    @Test
    public void testErrorMessageSymbol() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        SubmitNewLanguagePage submitNewLanguagePage = mainPage.navigateToSubmitLanguagePage();

        Assert.assertEquals(true, submitNewLanguagePage.verifyErrorPFIIList());
    }

// Task# 11-13
    @Test
    public void testImportantMessage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        SubmitNewLanguagePage submitNewLanguagePage = mainPage.navigateToSubmitLanguagePage();

        Assert.assertEquals(true, submitNewLanguagePage.verifyImportantMessage());
    }

//  Task# 11-21
    @Test
    public void testWordStyleWhiteFontTC_21() {
        MainPage mainpage = new MainPage(driver);
        mainpage.openBasePage();
        SubmitNewLanguagePage submitNewLanguagePage = mainpage.navigateToSubmitLanguagePage();
        Assert.assertTrue(submitNewLanguagePage.importantWhite().getAttribute("style").contains("color: white"));

    }

    @Test
    public void testWordStyleBoldFontTC_21() {
        MainPage mainpage = new MainPage(driver);
        mainpage.openBasePage();
        SubmitNewLanguagePage submitNewLanguagePage = mainpage.navigateToSubmitLanguagePage();

        Assert.assertEquals(submitNewLanguagePage.importantBoltVSCapital().getTagName(), "b");
    }

    @Test
    public void testWordStyleRedBackgroundTC_21() {
        MainPage mainpage = new MainPage(driver);
        mainpage.openBasePage();
        SubmitNewLanguagePage submitNewLanguagePage = mainpage.navigateToSubmitLanguagePage();

        Assert.assertTrue(submitNewLanguagePage.importantBgRed().getAttribute("style").contains("background-color: red"));
    }

    @Test
    public void testWordStyleAllCapitalTC_21() {
        MainPage mainpage = new MainPage(driver);
        mainpage.openBasePage();
        SubmitNewLanguagePage submitNewLanguagePage = mainpage.navigateToSubmitLanguagePage();

        Assert.assertEquals(submitNewLanguagePage.importantBoltVSCapital().getText().replace(":", ""), "IMPORTANT");
    }

}


//    Sergey Demianenko
//    @Test
//    public void testErrorMessage(){
//        MainPage mainPage = new MainPage(driver);
//        mainPage.openBasePage();
//        SubmitNewLanguagePage submitNewLanguagePage = mainPage.navigateToSubmitLanguagePage();
//        submitNewLanguagePage.submitLanguageButton();
//
//        Assert.assertEquals(true, submitNewLanguagePage.verifyErrorMessage());
//
//
//    }
//}
