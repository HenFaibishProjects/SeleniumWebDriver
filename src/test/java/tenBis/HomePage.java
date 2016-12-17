package tenBis;

import org.openqa.selenium.By;

public class HomePage  extends TenBisBaseTest{
	
	
	protected static By closeComersial  = By.xpath("/html/body/div[10]/div[3]/div[2]/span");
	
	
	
	public static void closepopup()
	{
		driver.findElement(closeComersial).click();
	}
	
	
	
	public void differenteUser()
	{}

}
