package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DisappearingElementsPage {

    private WebDriver driver;
    private By list_Items = By.tagName("li");
    private By galleryElement = By.cssSelector("a[href='/gallery/']");

    public DisappearingElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkIfGalleryElementIsPresent() {
        List<WebElement> presentElements = driver.findElements(list_Items);
        for (WebElement element : presentElements) {
            if (element.getText().contains("Gallery")) {
                return true;
            }
        }
        return false;
    }

    public void pageRefresh() {
        driver.navigate().refresh();
    }

    public void waitForGalleryElementToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("a[href='/gallery/']")));
    }

    public void waitForGalleryElementToAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/gallery/']")));
    }
}
