package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class baseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup () {
     //   System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");  // Old way of doing things
        WebDriverManager.chromedriver().setup();   // Using WebDriverManager doesn't require to download chromedriver
        driver = new ChromeDriver(getChromeOptions());
        goHome();
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
      //  setCookie();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {

            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/Screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown () {
       // driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");//, "--headless");
        return options;
    }

    //To add cookie to the session
//    private void setCookie() {
//        Cookie cookie = new Cookie.Builder("TAU", "1234")
//                .domain("the-internet.herokuapp.com")
//                .build();
//        driver.manage().addCookie(cookie);
//    }

}
