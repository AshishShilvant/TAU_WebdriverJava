package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {

    private WebDriver driver;
    private By firstColumn = By.id("column-a");
    private By secondColumn = By.id("column-b");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void dragFirstColumnTowardsSecond() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(firstColumn), driver.findElement(secondColumn)).perform();
    }

    public void dragSecondColumnTowardsFirst() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(firstColumn), driver.findElement(secondColumn)).perform();
    }

    public String validateNewTextOfFirstColumns() {
        return driver.findElement(firstColumn).getText();
    }

    public String validateNewTextOfSecondColumns() {
        return driver.findElement(secondColumn).getText();
    }
}
