package pageTests;

import pageObjects.MainPage;
import pageObjects.TopListsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopListsTest extends BaseTest {
    @Test
    public void ColumnHeadingTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        TopListsPage topListsPage = mainPage.navigateToTopListsPage();
//        Assert.assertTrue(topListsPage.verifyColumnNamesList());

        Assert.assertEquals(true, topListsPage.verifyColumnNamesList());
    }

}
