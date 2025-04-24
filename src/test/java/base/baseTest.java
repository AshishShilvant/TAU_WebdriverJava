package base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.ConfigReader;
import utils.ExtentTestManager;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class baseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup () {
     //   System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");  // Old way of doing things

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();   // Using WebDriverManager doesn't require to download chromedriver
            driver = new ChromeDriver(getChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        goHome();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.className("heading"), "Welcome to the-internet"));*/
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get(ConfigReader.getProperty("base.url"));
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
                ExtentTestManager.getTest().fail(result.getName() + " test failed.",
                MediaEntityBuilder.createScreenCaptureFromPath("resources/Screenshots/" + result.getName() + ".png").build());

                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
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
