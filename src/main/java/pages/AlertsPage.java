package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By JSAlertButton = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private By JSConfirmButton = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private By JSPromptButton = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
    private By result = By.id("result");

    public AlertsPage (WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert() {
        driver.findElement(JSAlertButton).click();
    }

    public void triggerConfirm() {
        driver.findElement(JSConfirmButton).click();
    }

    public void triggerPrompt() {
        driver.findElement(JSPromptButton).click();
    }

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void alert_enterText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }

    public String getResultText () {
        return driver.findElement(result).getText();
    }
}
