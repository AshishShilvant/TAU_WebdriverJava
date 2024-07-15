package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementsPage {

    private WebDriver driver;
    private By addButton = By.cssSelector("button[onclick='addElement()']");
    private By deleteButton = By.className("added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddElementButton() {
        driver.findElement(addButton).click();
    }

    public String getDeleteButtonText() {
        return driver.findElement(deleteButton).getText();
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }

    public boolean isDeleteButtonDisplayed() {
        return driver.findElement(deleteButton).isDisplayed();
    }
}
