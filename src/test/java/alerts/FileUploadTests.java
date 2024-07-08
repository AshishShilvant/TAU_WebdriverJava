package alerts;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends baseTest {

    @Test
    public void testFileUpload() {
        var fileUploadPage = homePage.clickOnFileUpload();
        String filePath = "C:\\Ashish\\IdeaIntelliJProjects\\TestAutomationUniversity\\Webdriver_Java\\resources\\chromedriver.exe";
        fileUploadPage.uploadFile(filePath);
        fileUploadPage.clickUploadButton();
        Assert.assertEquals(fileUploadPage.getUploadedFileText(), "chromedriver.exe"
        , "Upload file is incorrect");
    }
}
