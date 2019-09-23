package dimashyshkin.tests.workingWithFrames;


import dimashyshkin.Infra.TestUtilities;
import dimashyshkin.pages.EditorPage;
import dimashyshkin.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EditorTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on WYSIWYG Editor link
        EditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();

        // Get default editor text
        String editorText = editorPage.getEditorText();

        // Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }
}