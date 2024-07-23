package disappearingElements;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisappearingElementsTests extends baseTest {

    @Test
    public void testDisappearingAndReappearingElements() {
        var disappearingElementsPage = homePage.clickDisappearingElements();
        boolean isGalleryElementPresent = disappearingElementsPage.checkIfGalleryElementIsPresent();

        if (isGalleryElementPresent) {
            disappearingElementsPage.pageRefresh();
            disappearingElementsPage.waitForGalleryElementToDisappear();
            Assert.assertFalse(disappearingElementsPage.checkIfGalleryElementIsPresent(),
                    "Gallery element is not present anymore");
        } else {
            disappearingElementsPage.pageRefresh();
            disappearingElementsPage.waitForGalleryElementToAppear();
            Assert.assertTrue(disappearingElementsPage.checkIfGalleryElementIsPresent(),
                    "Gallery element is present on the page now");
        }

    }
}
