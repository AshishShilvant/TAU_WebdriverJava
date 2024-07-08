package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;
    private By inputField = By.id("target");
    private By textResult = By.id("result");

    public KeyPressesPage (WebDriver driver) {
        this.driver = driver;
    }

    public void enterText (String text) {
        driver.findElement(inputField).sendKeys(text);
    }

    public void enterPi () {
        enterText(Keys.chord(Keys.ALT));   // This is not working yet, need to find out a solution.
    }

    public String getResult () {
        return driver.findElement(textResult).getText();
    }
}
