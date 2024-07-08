package alerts;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTests extends baseTest {

    @Test
    public void testContextMenuClick() {
        var contextMenuPage = homePage.clickOnContextMenu();
        contextMenuPage.rightClickInsideBox();
        String alertText = contextMenuPage.getAlertText();
        contextMenuPage.confirmJavaScriptAlert();
        Assert.assertEquals(alertText, "You selected a context menu", "Alert text is incorrect");
    }
}
