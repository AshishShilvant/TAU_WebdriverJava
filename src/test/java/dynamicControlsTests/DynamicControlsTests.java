package dynamicControlsTests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTests extends baseTest {

    @Test
    public void testAddRemoveCheckbox() {
        var dynamicControlsPage = homePage.clickDynamicControls();
        dynamicControlsPage.clickCheckbox();
        dynamicControlsPage.clickRemoveButton();
        Assert.assertTrue(dynamicControlsPage.isAddButtonDisplayed());
        Assert.assertEquals(dynamicControlsPage.getCheckboxRemovalConfirmationText(), "It's gone!", "Confirmation text is incorrect");

        dynamicControlsPage.clickAddButton();
        Assert.assertTrue(dynamicControlsPage.isRemoveButtonDisplayed());
        Assert.assertEquals(dynamicControlsPage.getCheckboxReaddConfirmationText(), "It's back!", "Confirmation text is incorrect");
    }

    @Test
    public void testEnableDisableAButton() {
        var dynamicControlsPage = homePage.clickDynamicControls();
        dynamicControlsPage.clickEnableButton();
        String text = "Ashish";
        dynamicControlsPage.enterTextInEnabledTextField(text);
        Assert.assertTrue(dynamicControlsPage.isDisableButtonDisplayed());
        Assert.assertEquals(dynamicControlsPage.getEnableConfirmationText(), "It's enabled!", "Confirmation text is incorrect");

        dynamicControlsPage.clickDisableButton();
        Assert.assertTrue(dynamicControlsPage.isEnableButtonDisplayed());
        Assert.assertEquals(dynamicControlsPage.getDisableConfirmationText(), "It's disabled!", "Confirmation text is incorrect");
    }
}
