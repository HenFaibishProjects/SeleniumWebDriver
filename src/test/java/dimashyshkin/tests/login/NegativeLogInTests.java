package dimashyshkin.tests.login;


import dimashyshkin.Infra.TestUtilities;
import dimashyshkin.pages.LoginPage;
import dimashyshkin.pages.WelcomePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class NegativeLogInTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");

        // open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, (Logger) log);
        welcomePageObject.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();

        // enter username and password
        loginPage.negativeLogIn(username, password);


        // wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();

        // Verification
        Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
    }

}