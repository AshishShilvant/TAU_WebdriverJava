package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;
  //  private String linkXpath_format = ".//a[contains(text(), %s)]";
    private By example1Link = By.xpath("//a[contains(text(),'Example 1')]");
    private By example2Link = By.xpath("//a[contains(text(),'Example 2')]");
  //  private By example1Link = By.xpath(String.format(linkXpath_format, "Example1"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(example1Link).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2() {
        driver.findElement(example2Link).click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample2Page controlClickExample2() {
        driver.findElement(example2Link).sendKeys(Keys.CONTROL, Keys.ENTER);
        return new DynamicLoadingExample2Page(driver);
    }

}
