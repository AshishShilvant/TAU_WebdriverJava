package hovers;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTests extends baseTest {

    @Test
    public void testHoverUser1 () {
        var hoversPage = homePage.clickHoversLink();
        var caption = hoversPage.hoverOverFigure(1);
        Assert.assertTrue(caption.isCaptionDisplayed(), "Caption is not displayed");
        Assert.assertEquals(caption.getTitle(), "name: user1", "Caption title is incorrect");
        Assert.assertEquals(caption.getLinkText(), "View profile", "Caption link test is incorrect");
        Assert.assertTrue(caption.getLink().endsWith("/users/1"), "Link is incorrect");

    }
}
