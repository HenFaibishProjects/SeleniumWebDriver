package tevaCastel;

import org.testng.annotations.DataProvider;



public class DataProviderTevaCastel  {


	@DataProvider(name = "HenFullCharge")
	public static Object[][] dataProviderLoadDevicesExist() throws Exception {
		return new Object[][] {
			{
				"חן פייביש",
				"0542689621",
				"2815",
				"100",
				"14:00"
			},
			
		};
	}
}