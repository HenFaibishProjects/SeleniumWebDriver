package vitaCost;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class TestAmmount extends VitaCostTestBase{


		protected static final Logger LOGGER = Logger.getLogger(TestAmmount.class.getName());

		@BeforeTest
		public void beforeActualCharging() {
			startthesettings(preferendWebBrowser,mainWebServerURL);
			login();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			findProduct(productToSearch);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			clickOnProductLink();
			LOGGER.info(mainWebServerURL + " " + "is open on browser " + preferendWebBrowser);
		}
		
		
		
		@Test(enabled = true)
		public void TestMyDesirePriceAndSendMeAnEmailWhenDone() {
			float result = getOurPriceText();
			      InputOutputFiles.screenshot();
				  SendEmail.mainsend(expectedPrice,result); 
				  //InputOutputFiles.DeleteFile();
			  
			
			
		}
		
		@AfterTest
		public void shutDownSelenium() {
		    driver.quit();
		    LOGGER.info("browser " + preferendWebBrowser + " " + "is closed now");
		}
		

		
		


}
