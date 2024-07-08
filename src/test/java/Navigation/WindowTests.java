package Navigation;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowTests extends baseTest {

    @Test
    public void testWindowTabs(){
        var buttonPage = homePage.clickDynamicLoading().controlClickExample2();
        getWindowManager().switchWindowTab();
        Assert.assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");
    }
}
