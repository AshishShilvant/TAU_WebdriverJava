package forgotpassword;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTests extends baseTest {

    @Test
    public void testForgotPassword () {
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        String emailID = "ashish@example.com";
        forgotPasswordPage.enterEmailId(emailID);
        var emailSentPage = forgotPasswordPage.clickOnRetrievePasswordButton();

        Assert.assertTrue(emailSentPage.getConfirmationMessage().contains("Your e-mail's been sent!"),
                "Password reset email has not been sent successfully, Try again!");
    }
}
