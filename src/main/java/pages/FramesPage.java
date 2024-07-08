package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private WebDriver driver;
    private By nestedFramesLink = By.linkText("Nested Frames");
    private By body = By.tagName("body");
    private String topFrameID = "frame-top";
    private String leftFrameID = "frame-left";
    private String bottomFrameID = "frame-bottom";


    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnNestedFrames() {
        driver.findElement(nestedFramesLink).click();
    }

    public String getTextFromLeftFrame() {
        goToLeftFrame();
        String leftFrameText = driver.findElement(body).getText();
        switchToParentFrame();
        return leftFrameText;
    }

    public String getTextFromBottomFrame() {
        goToBottomFrame();
        String bottomFrameText = driver.findElement(body).getText();
        switchToParentFrame();
        return bottomFrameText;
    }

    private void goToLeftFrame() {
        driver.switchTo().frame(topFrameID);
        driver.switchTo().frame(leftFrameID);
    }

    private void goToBottomFrame() {
        driver.switchTo().frame(bottomFrameID);
    }

    private void switchToParentFrame() {
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
    }
}
