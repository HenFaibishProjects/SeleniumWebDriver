package dimashyshkin.tests.checkboxespage;


import dimashyshkin.Infra.TestUtilities;
import dimashyshkin.pages.CheckboxesPage;
import dimashyshkin.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {
        log.info("Starting selectingTwoCheckboxesTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on Checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        // Select All Checkboxes
        checkboxesPage.selectAllCheckboxes();

        // Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");

    }
}