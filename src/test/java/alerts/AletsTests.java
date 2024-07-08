package alerts;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AletsTests extends baseTest {

    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickOnJavaScriptAlert();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResultText(),
                "You successfully clicked an alert", "Result text is incorrect");
    }

    @Test
    public void testDismissAlert() {

        var alertsPage = homePage.clickOnJavaScriptAlert();
        alertsPage.triggerConfirm();
        String alertText = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        Assert.assertEquals(alertText, "I am a JS Confirm", "Alert text is incorrect");
    }

    @Test
    public void testEnterTextIntoAlert() {

        var alertsPage = homePage.clickOnJavaScriptAlert();
        alertsPage.triggerPrompt();
        String text = "TAU Rocks!";
        alertsPage.alert_enterText(text);
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResultText(), "You entered: " + text, "Result text is incorrect");
    }
}
