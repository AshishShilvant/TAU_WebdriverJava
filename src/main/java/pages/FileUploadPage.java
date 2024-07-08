package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;
    private By fileUpload = By.id("file-upload");
    private By fileSubmit = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String absolutePathOfFile) {
        driver.findElement(fileUpload).sendKeys(absolutePathOfFile);
    }

    public void clickUploadButton() {
        driver.findElement(fileSubmit).click();
    }

    public String getUploadedFileText() {
        return driver.findElement(uploadedFile).getText();
    }
}
