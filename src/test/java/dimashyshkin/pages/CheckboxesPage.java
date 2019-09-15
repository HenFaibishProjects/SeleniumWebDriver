package dimashyshkin.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePageObject {

    private By checkbox = By.xpath("//input[@type='checkbox']");
    public By checkbox1 = By.xpath("//*[@id='checkboxes']/input[1]");
    public By checkbox2 = By.xpath("//*[@id='checkboxes']/input[2]");

    public CheckboxesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get list of all checkboxes and check if unchecked */
    public void selectAllCheckboxes() {
        log.info("Checking all unchecked checkboxes");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void unSelectAllCheckboxes() {
        log.info("Checking all unchecked checkboxes");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void selectSpecific(By selector) {
        find(selector).click();

            }



    /**
     * Verify all available checkboxes are checked. If at least one unchecked,
     * return false
     */
    public boolean areAllCheckboxesChecked() {
        log.info("Verifying that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }

    public boolean areUnAllCheckboxesChecked() {
        log.info("Verifying that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return true;
            }
        }
        return false;
    }
}
