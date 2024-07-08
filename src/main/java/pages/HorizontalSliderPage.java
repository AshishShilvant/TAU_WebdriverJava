package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.cssSelector("input[type='range']");
    private By textValue = By.id("range");

    public HorizontalSliderPage (WebDriver driver) {
        this.driver = driver;
    }

    public void moveSlider (String value) {

        //One way of doing it; other way below
        /*int countOfArrowRight = 8;
        StringBuilder chordString = new StringBuilder();
        for (int count = 0 ; count < countOfArrowRight ; count++) {
            chordString.append(Keys.ARROW_RIGHT);
        }
        driver.findElement(slider).sendKeys(chordString.toString());*/

        //Second way of doing it
        while (!getTextValue().equals(value)) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }


    }

    public String getTextValue () {
        return driver.findElement(textValue).getText();
    }
}
