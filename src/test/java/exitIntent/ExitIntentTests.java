package exitIntent;

import base.baseTest;
import org.testng.annotations.Test;

public class ExitIntentTests extends baseTest {

    @Test
    public void testModalAppearance() {
        var exitIntentPage = homePage.clickExitIntent();
        exitIntentPage.moveMouseOutOfViewportPane();
        String modalHeaderText = exitIntentPage.getModalHeaderText();
        System.out.println(modalHeaderText);
        if (exitIntentPage.isModalDisplayed()) {
            exitIntentPage.clickCloseCTA();
        }
    }
}
