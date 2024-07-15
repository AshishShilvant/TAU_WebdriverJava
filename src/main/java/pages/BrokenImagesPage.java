package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImagesPage {

    private WebDriver driver;

    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllImagesPresent() {
        List<WebElement> images_List = driver.findElements(By.tagName("img"));
        return images_List;
    }
}
