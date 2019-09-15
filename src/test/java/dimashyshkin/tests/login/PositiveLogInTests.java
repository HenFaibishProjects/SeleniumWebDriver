package dimashyshkin.tests.login;

import dimashyshkin.Infra.TestUtilities;
import dimashyshkin.pages.LoginPage;
import dimashyshkin.pages.SecureAreaPage;
import dimashyshkin.pages.WelcomePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogInTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");

        // create driver with welcome page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver , (Logger) log);

        // open main page
        welcomePageObject.openPage();

        // Click on Form Authentication link
        LoginPage loginPage =  welcomePageObject.clickFormAuthenticationLink();

        // execute login
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith","SuperSecretPassword!");

        // verifications
        // new url
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        // log out button is visible
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(),"logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}