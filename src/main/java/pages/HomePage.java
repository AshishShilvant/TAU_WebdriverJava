package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickDropDown () {
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    public ForgotPasswordPage clickForgotPasswordLink () {
        clickLink("Forgot Password");
        return new ForgotPasswordPage (driver);
    }

    public HoversPage clickHoversLink () {
        clickLink("Hovers");
        return new HoversPage (driver);
    }

    public KeyPressesPage clickKeyPresses () {
        clickLink("Key Presses");
        return new KeyPressesPage (driver);
    }

    public HorizontalSliderPage dragSlider () {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage (driver);
    }

    public AlertsPage clickOnJavaScriptAlert () {
        clickLink("JavaScript Alerts");
        return new AlertsPage (driver);
    }

    public FileUploadPage clickOnFileUpload() {
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickOnContextMenu() {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygEditorPage clickOnWysiwygEditor() {
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickOnFrames() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom() {
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll() {
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows() {
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    public AddRemoveElementsPage clickAddRemoveElements() {
        clickLink("Add/Remove Elements");
        return new AddRemoveElementsPage(driver);
    }

    public BrokenImagesPage clickBrokenImages() {
        clickLink("Broken Images");
        return new BrokenImagesPage(driver);
    }

    public CheckboxesPage clickCheckboxes() {
        clickLink("Checkboxes");
        return new CheckboxesPage(driver);
    }

    public BasicAuthPage clickBasicAuth() {
        clickLink("Basic Auth");
        return new BasicAuthPage(driver);
    }

    public DisappearingElementsPage clickDisappearingElements() {
        clickLink("Disappearing Elements");
        return new DisappearingElementsPage(driver);
    }

    public DragAndDropPage clickDragAndDrop() {
        clickLink("Drag and Drop");
        return new DragAndDropPage(driver);
    }

    private void clickLink (String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
