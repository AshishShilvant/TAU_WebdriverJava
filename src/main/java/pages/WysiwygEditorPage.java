package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private By closeIcon = By.cssSelector("div.tox-icon");
    private String textAreaID = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndent = By.cssSelector("button[title='Increase indent']");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCloseIcon() {
        driver.findElement(closeIcon).click();
    }

    public void clearTextArea() {
        switchToTextArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void typeInTextArea(String text) {
        switchToTextArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public void clickOnIncreaseIndent() {
        driver.findElement(increaseIndent).click();
    }

    public String getTextFromTextArea() {
        switchToTextArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToTextArea() {
        driver.switchTo().frame(textAreaID);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }


}
