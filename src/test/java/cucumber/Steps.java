package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Steps {

    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By logInButton = By.cssSelector(".radius");
    private By statusAlert = By.id("flash");

    @Given("The user is on the login page of the Para Bank web application")
    public void the_user_is_on_the_login_page_of_the_para_bank_web_application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        driver.findElement(username).sendKeys("tomsmith");
        driver.findElement(password).sendKeys("SuperSecretPassword!");
        driver.findElement(logInButton).click();
    }

    @Then("account overview page should be displayed")
    public void account_overview_page_should_be_displayed() {
        String statusAlertText = driver.findElement(statusAlert).getText();
        Assert.assertTrue(statusAlertText.contains("You logged into a secure area!"));

    }
}
