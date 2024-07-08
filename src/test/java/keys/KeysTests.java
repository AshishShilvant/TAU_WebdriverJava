package keys;

import base.baseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeysTests extends baseTest {

    @Test
    public void testBackspace () {
        var keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressesPage.getResult(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi () {
        var keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterPi();
    }

}
