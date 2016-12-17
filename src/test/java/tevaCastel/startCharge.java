package tevaCastel;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class startCharge  extends TevaCastelBaseTest{

	protected static final Logger LOGGER = Logger.getLogger(startCharge.class.getName());

	@BeforeTest
	public void beforeActualCharging() {
		startthesettings(preferendWebBrowser,webServerURL);
		LOGGER.info(webServerURL + " " + "is open on browser " + preferendWebBrowser);
	}



	@Test(dataProviderClass = DataProviderTevaCastel.class, dataProvider = "HenFullCharge", enabled = true)
	public void fullCahrge(String fullname, String phone, String cardNumber, String amount , String chargeTime) throws Exception {
		driver.findElement(By.name(fullNameF)).sendKeys(fullname);
		driver.findElement(By.name(telephoneId)).sendKeys(phone);
		driver.findElement(By.name(numberCstelId)).sendKeys(cardNumber);
		driver.findElement(By.name(chargeAmountid)).sendKeys(amount);
		driver.findElement(By.name(hourId)).sendKeys(chargeTime);
	}

	
	@AfterTest
	public void shutDownSelenium() {
	    driver.quit();
	    LOGGER.info("browser " + preferendWebBrowser + " " + "is closed now");
	}
	

}

