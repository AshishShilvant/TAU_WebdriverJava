package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class CheckboxesPage {

    private WebDriver driver;
    private By checkboxes = By.cssSelector("input[type='checkbox']");


    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    private List<WebElement> getCheckboxes() {
        return driver.findElements(checkboxes);
    }

    public HashMap<String, Boolean> getCheckboxesCurrentState() {
        List<WebElement> list_Checkboxes = getCheckboxes();
        HashMap<String, Boolean> checkboxState = new HashMap<>();

        for (int i = 0; i < list_Checkboxes.size(); i++) {
            WebElement checkbox = list_Checkboxes.get(i);
            checkboxState.put(String.valueOf(i), checkbox.isSelected());
        }
        return checkboxState;
    }

    public void clickCheckboxesToChangeState() {
        List<WebElement> list_Checkboxes = getCheckboxes();
        for (WebElement checkbox : list_Checkboxes) {
            checkbox.click();
        }
    }
}
