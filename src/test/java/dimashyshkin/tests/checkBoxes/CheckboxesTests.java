package dimashyshkin.tests.checkBoxes;

import dimashyshkin.Infra.TestUtilities;
import dimashyshkin.pages.CheckboxesPage;
import dimashyshkin.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    private WelcomePageObject welcomePage;
    private CheckboxesPage checkboxesPage;

@BeforeMethod
    public void setUp()  {
        // open main page
        welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on Checkboxes link
        checkboxesPage = welcomePage.clickCheckboxesLink();

    }

    @Test
    public void checkAll(){

        // Select All Checkboxes
        checkboxesPage.selectAllCheckboxes();

        // Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");


    }

    @Test
    public void unCheckAll(){
        checkboxesPage.unSelectAllCheckboxes();
        // Verify all checkboxes are unchecked
        Assert.assertTrue(checkboxesPage.areUnAllCheckboxesChecked(), " all checkboxes are Unchecked");


    }

    @Test
    public void checkSpecific(){
        checkboxesPage.unSelectAllCheckboxes();
        sleep(5000);
        checkboxesPage.selectSpecific(checkboxesPage.checkbox1);
        sleep(5000);
        checkboxesPage.selectSpecific(checkboxesPage.checkbox2);
        sleep(5000);

    }

}