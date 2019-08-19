package tenBis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import infra.BaseTest;

public class TenBisBaseTest extends BaseTest{
	


	/******************************* General Details **********************************************/

	protected String preferendWebBrowser = "Firefox";
	protected String mainWebServerURL = "https://www.10bis.co.il/";
	protected static String chargingWebServerURL = "https://www.10bis.co.il/Account/UserReportv";  
	protected static String userMail = "SomeMail@SomeDomain.com";
	protected static String userPassword = "SomePassword";
	protected final static float amountGivenPrice = 850;
	protected float currentAmount;
	protected float leftAmount;
	public static String pathFora = "/screenshots/tenbisMessage.txt";
	

	/******************************* Objects **********************************************/
	protected static By spendThisMounth  = By.xpath("//*[@class='totalsFieldValueTh currency']");  //1
	protected static By changeUser   = By.xpath("//span[@class='upperBarLink']"); //0
	protected static By emailPassword = By.xpath("//div[@class='inputLogOnTd']/input[@class='defaultInput']");  // 0 and 1
	protected static By registerUser =        By.xpath("//div[@class='HomePageActionButton HomePageStraightBtn']"); //[0]
	protected static By clickEnterLogin = By.xpath("//div[@class='Arrow']"); //1
	
	/***************************************** Methhods ***************************************/
	

	
	public static void gotoChargingPage() {
		
		driver.get(chargingWebServerURL);
	}
}




