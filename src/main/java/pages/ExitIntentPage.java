package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ExitIntentPage {

    private WebDriver driver;
    private By modal = By.className("modal");
    private By modalHeaderText = By.xpath("//div[@class='modal-title']//h3");
    private By closeCTA = By.linkText("Close");

    public ExitIntentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveMouseOutOfViewportPane() {
        Actions actions = new Actions(driver);
        actions.moveByOffset(1000, 35).perform();
    }

    public boolean isModalDisplayed() {
        return driver.findElement(modal).isDisplayed();
    }

    public String getModalHeaderText() {
        return driver.findElement(modalHeaderText).getText();
    }

    public void clickCloseCTA() {
        driver.findElement(closeCTA).click();
    }
}
