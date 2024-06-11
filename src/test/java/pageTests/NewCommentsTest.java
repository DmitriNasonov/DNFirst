package pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.NewCommentsPage;
import pageObjects.TopListsPage;

public class NewCommentsTest extends BaseTest{
//  Task# 11-15
    @Test
    public void ColumnHeadingTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openBasePage();
        TopListsPage topListsPage = mainPage.navigateToTopListsPage();
        NewCommentsPage newCommentsPage = topListsPage.navigateToNewCommentsPage();


        Assert.assertEquals(false, newCommentsPage.verifyComments());
    }
}
