package dimashyshkin.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{


    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

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

}
