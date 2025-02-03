package dropdown;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExtentTestManager;

import java.util.List;

public class DropDownTests extends baseTest {

    @Test
    public void testSelectOption () {
        ExtentTestManager.startTest("Dropdown Test - Single Selection", "Verifying dropdown functionality for single selection");

        var dropDownPage = homePage.clickDropDown();
        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
       // Assert.assertEquals(selectedOptions.size(), 2, "Incorrect number of selections");
        Assert.fail();
        Assert.assertTrue(selectedOptions.contains(option), "Required option is not selected");

        ExtentTestManager.endTest();
    }

    @Test
    public void testMultipleSelectionFromDropDown() {
        ExtentTestManager.startTest("Dropdown Test - Multiple selection", "Verifying dropdown functionality for multiple selection");

        var dropDownPage = homePage.clickDropDown();
        dropDownPage.showMultipleDropDownOptions();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropDownPage::selectFromDropDown);

        var selectedOptions = dropDownPage.getSelectedOptions();
        Assert.assertTrue(selectedOptions.containsAll(optionsToSelect), "All options are not present");
        Assert.assertEquals(selectedOptions.size(), optionsToSelect.size(), "Incorrect number of selections");

        ExtentTestManager.endTest();
    }
}
