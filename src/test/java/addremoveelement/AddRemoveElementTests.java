package addremoveelement;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementTests extends baseTest {

    @Test
    public void testAddingRemovingElements() {
        var addRemoveElementsPage = homePage.clickAddRemoveElements();
        addRemoveElementsPage.clickAddElementButton();
        String text = addRemoveElementsPage.getDeleteButtonText();
        Assert.assertTrue(text.contains("Delete"), "Text doesn't match");
        if (addRemoveElementsPage.isDeleteButtonDisplayed()) {
            addRemoveElementsPage.clickDeleteButton();
        }
    }
}
