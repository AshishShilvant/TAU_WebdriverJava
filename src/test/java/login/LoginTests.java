package login;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends baseTest {

    @Test
    public void testSuccessfulLogin () {
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLogin();
        Assert.assertTrue(secureAreaPage.getStatusAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect.");
    }
}
