package vitaCost;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import infra.BaseTest;

public class VitaCostTestBase extends BaseTest{



	/******************************* General Details **********************************************/

	protected String preferendWebBrowser = "Firefox";
	protected String mainWebServerURL = "https://www.vitacost.com";
	protected String loginWebServerURL = "https://www.vitacost.com/MyAccount/Login.aspx?ISRC=myaccount:topnav";
	protected String userMail = "zzzi10@gmail.com";
	protected String userPassword = "itmaster";
	protected String productToSearch = "BPI Best BCAA Blue Raspberry -- 30 Servings";
	protected float expectedPrice = 40;
	public static String pathFora = "/screenshots/a.txt";
	



	/******************************* Objects **********************************************/

	protected String a= "";
	protected By inputValueBox = By.id("searchInput");
	protected By SearchInput = By.id("C_LeftNav_SearchGo");
	protected By shopingBag = By.id("CartItemsQty");
	protected By inputValueBoxXpath =  By.xpath("//input[@type='search']"); //[0]
	protected By inputEmailBox = By.id("IamMasterFrameYesIam_ctl02_objLogin_txtExistingCustomerEmail");
	protected By inputPasswordBox   = By.id("IamMasterFrameYesIam_ctl02_objLogin_txtExistingCustomerPassword");
	protected By singInButton   = By.id("IamMasterFrameYesIam_ctl02_objLogin_buttonLogin");		
	protected By productLink   = By.xpath("//img[@alt='BPI Best BCAA Blue Raspberry']");
	protected static By ourPrice = By.xpath("//li[@id='pdpSubPrice']/p[position() = 2]");

	/***************************************** Methhods ***************************************/
	public void login()
	{	 
		driver.get(loginWebServerURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(inputEmailBox).clear();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(inputEmailBox).sendKeys(userMail);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(inputPasswordBox).clear();
		driver.findElement(inputPasswordBox).sendKeys(userPassword);
		driver.findElement(singInButton).click();  

	}

	public void findProduct(String productName)
	{	 	
		driver.findElement(inputValueBox).clear();
		driver.findElement(inputValueBox).sendKeys(productName);
		driver.findElement(SearchInput).click(); //inputValueBox.sendKeys(Keys.RETURN); 
	}

	public void clickOnProductLink()
	{	 	
		driver.findElements(productLink).get(0).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		InputOutputFiles.screenshot();

	}

	public static float getOurPriceText()
	{	
		float amount = 0;
		String outPriceLine = driver.findElements(ourPrice).get(0).getText();
		Matcher m = Pattern.compile("\\d+\\.\\d+").matcher(outPriceLine);
		if (m.find()) {
			String stringAmount = m.group(0);
			amount=Float.parseFloat(stringAmount);
		}
		return amount;
	}
	
	
}
