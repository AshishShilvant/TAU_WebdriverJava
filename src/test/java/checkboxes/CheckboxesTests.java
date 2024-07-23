package checkboxes;

import base.baseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckboxesTests extends baseTest {

    @Test
    public void testCurrentCheckboxesState() {
        var checkboxesPage = homePage.clickCheckboxes();
        HashMap<String, Boolean> state = checkboxesPage.getCheckboxesCurrentState();
        for (Map.Entry<String, Boolean> currentState : state.entrySet()) {
            System.out.println("Checkbox " + currentState.getKey() + " is "
                    + (currentState.getValue() ? "Selected" : "Not Selected"));
        }
    }

    @Test
    public void testClickingCheckboxes() {
        var checkboxesPage = homePage.clickCheckboxes();
        checkboxesPage.clickCheckboxesToChangeState();
    }
}
