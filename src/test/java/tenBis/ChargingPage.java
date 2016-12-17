package tenBis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChargingPage extends TenBisBaseTest {
	
	public static float getOurPriceText()
	{	
		float amount = 0;
		String spendThisMounthValue = driver.findElements(spendThisMounth).get(1).getText();
		Matcher m = Pattern.compile("\\d+..").matcher(spendThisMounthValue);
		if (m.find()) {
			String stringAmount = m.group(0);
			amount=Float.parseFloat(stringAmount);
		}
		return amount;
	}
	
	public static float getHowMuchLeft(float getvalue)
	{	
	return (amountGivenPrice - getvalue);	
	}
}
