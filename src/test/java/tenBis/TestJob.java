package tenBis;

import java.util.logging.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestJob extends TenBisBaseTest{


	protected static final Logger LOGGER = Logger.getLogger(TestJob.class.getName());

	@BeforeTest
	public void beforeActualCharging() {
		startthesettings(preferendWebBrowser,mainWebServerURL);
		waitUntil(10);
		deleteAllCookiesInTheBrowser();

	}



	@Test(enabled = true)
	public void TestMyDesirePriceAndSendMeAnEmailWhenDone() {
		LoginPage.createFullLogin();
		waitUntil(10);
		super.gotoChargingPage();
		
		

	}
}