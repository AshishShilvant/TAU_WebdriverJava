package brokenImages;

import base.baseTest;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImagesTests extends baseTest {

    @Test
    public void testBrokenImagesPresent() {
        int brokenImagesCount = 0;
        String status = "passed";
        var brokenImagesPage = homePage.clickBrokenImages();

        try {
            List<WebElement> imageList =  brokenImagesPage.getAllImagesPresent();
            System.out.println("The page have " + imageList.size() + " images");
            for (WebElement img : imageList) {
                if (img != null) {
                    CloseableHttpClient client = HttpClientBuilder.create().build();
                    HttpGet request = new HttpGet(img.getAttribute("src"));
                    CloseableHttpResponse response = client.execute(request);
                    if (response.getCode() != 200) {
                        System.out.println(img.getAttribute("outerHTML") + " is broken");
                        brokenImagesCount++;
                    }
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            status = "failed";
            System.out.println(e.getMessage());
        }

        System.out.println("The page has total " + brokenImagesCount + " broken images");

    }
}
