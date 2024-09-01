package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage {

    private WebDriver driver;
    private By checkbox = By.xpath("//input[@type='checkbox']");
    private By removeButton = By.xpath("//button[contains(text(), 'Remove')]");
    private By addButton = By.cssSelector("button[onclick='swapCheckbox()']");
    private By firstLoadingBar = By.xpath("(//img[@src='/img/ajax-loader.gif'])[1]");
    private By removalConfirmationText = By.cssSelector("p#message");
    private By addConfirmationText = By.xpath("//p[contains(text(), \"It's back!\")]");
    private By enableButton = By.cssSelector("button[onclick='swapInput()']");
    private By enabledTextField = By.cssSelector("input[type='text']");
    private By disableButton = By.cssSelector("button[onclick='swapInput()']");
    private By enableConfirmationText = By.cssSelector("p#message");
    private By disableConfirmationText = By.xpath("//p[@id='message']");


    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckbox() {
        driver.findElement(checkbox).click();
    }

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
//        FluentWait wait = new FluentWait(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(removalConfirmationText)));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(removalConfirmationText));
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
//        FluentWait wait = new FluentWait(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(removeButton)));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(removeButton));
    }

    public boolean isAddButtonDisplayed() {
        return driver.findElement(addButton).isDisplayed();
    }

    public String getCheckboxRemovalConfirmationText() {
        return driver.findElement(removalConfirmationText).getText();
    }

    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(removeButton).isDisplayed();
    }

    public String getCheckboxReaddConfirmationText() {
        return driver.findElement(addConfirmationText).getText();
    }

    public void clickEnableButton() {
        driver.findElement(enableButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(enableConfirmationText));
    }

    public void enterTextInEnabledTextField(String text) {
        driver.findElement(enabledTextField).sendKeys(text);
    }

    public void clickDisableButton() {
        driver.findElement(disableButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(disableConfirmationText));
    }

    public boolean isDisableButtonDisplayed() {
        return driver.findElement(disableButton).isDisplayed();
    }

    public boolean isEnableButtonDisplayed() {
        return driver.findElement(enableButton).isDisplayed();
    }

    public String getEnableConfirmationText() {
        return driver.findElement(enableConfirmationText).getText();
    }

    public String getDisableConfirmationText() {
        return driver.findElement(disableConfirmationText).getText();
    }

}
