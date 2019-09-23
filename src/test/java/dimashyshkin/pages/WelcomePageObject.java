package dimashyshkin.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{


    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By editorLinkLocator = By.linkText("WYSIWYG Editor");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver,log);
    }



    /** Open WelcomePage with it's url */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        driver.get(pageUrl);
        log.info("Page opened!");
    }

    /** Open LoginPage by clicking on Form Authentication Link */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        driver.findElement(formAuthenticationLinkLocator).click();
        return new LoginPage(driver, log);
    }

    /** Open CheckboxesPage by clicking on Checkboxes Link */
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

    public EditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking WYSIWYG Editor link on Welcome Page");
        click(editorLinkLocator);
        return new EditorPage(driver, log);
    }

}
