package frames;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends baseTest {

    @Test
    public void testSwitchingToIFrame() {
        var wysiwygEditorPage = homePage.clickOnWysiwygEditor();
        wysiwygEditorPage.clearTextArea();
        String text1 = "hello ";
        String text2 = "world";
        wysiwygEditorPage.typeInTextArea(text1);
        wysiwygEditorPage.clickOnIncreaseIndent();
        wysiwygEditorPage.typeInTextArea(text2);
        Assert.assertEquals(wysiwygEditorPage.getTextFromTextArea(), "hello world", "Text is incorrect");
    }
}
