package wait;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTests extends baseTest {

    @Test
    public void testDynamicLoadingWait() {
        var dynamicLoadingExample1Page = homePage.clickDynamicLoading().clickExample1();
        dynamicLoadingExample1Page.clickStartButton();
        Assert.assertEquals(dynamicLoadingExample1Page.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }

    @Test
    public void testDynamicLoadingOnceElementIsVisible() {
        var dynamicLoadingExample2Page = homePage.clickDynamicLoading().clickExample2();
        dynamicLoadingExample2Page.clickStarButton();
        Assert.assertEquals(dynamicLoadingExample2Page.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }
}
