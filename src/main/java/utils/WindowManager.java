package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refresh() {
        navigate.refresh();
    }

    public void goTo(String URL) {
        navigate.to(URL);
    }

    public void switchWindowHandle(String tabHandle) {
        var windows = driver.getWindowHandles();
        System.out.println("Count of window handles: " + windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);

        for(String window : windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());
            if (tabHandle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    public void switchWindowTab() {
        var windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}
