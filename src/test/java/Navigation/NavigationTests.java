package Navigation;

import base.baseTest;
import org.testng.annotations.Test;

public class NavigationTests extends baseTest {

    @Test
    public void testBrowserNavigations() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refresh();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testSwtichingWindows() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchWindowHandle("New Window");
    }
}
