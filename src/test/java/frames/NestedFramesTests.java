package frames;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFramesTests extends baseTest {

    @Test
    public void testNestedFrames() {
        var framesPage = homePage.clickOnFrames();
        framesPage.clickOnNestedFrames();
        Assert.assertEquals(framesPage.getTextFromLeftFrame(), "LEFT", "Frame text is incorrect");
        Assert.assertEquals(framesPage.getTextFromBottomFrame(), "BOTTOM", "Frame text is incorrect");
    }
}
