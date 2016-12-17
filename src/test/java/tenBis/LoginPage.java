package tenBis;

public class LoginPage extends TenBisBaseTest {

	public static void enterUser(String user)
	{
		driver.findElements(emailPassword).get(0).sendKeys(user);
		waitUntil(5000);
	}

	public static void enterPassword(String password)
	{
		driver.findElements(emailPassword).get(1).sendKeys(password);
		waitUntil(5000);
	}

	public static void clickOnEnter()
	{
		driver.findElements(registerUser).get(0).click();	

	}

	public static void clickOnEnterAfterCredentials()
	{
		waitUntil(5000);
		driver.findElements(clickEnterLogin).get(1).click();
		waitUntil(5000);

	}

	public static void createFullLogin() {
		clickOnEnter();
		enterUser(userMail);
		enterPassword(userPassword);
		waitUntil(5000);
		clickOnEnterAfterCredentials();
		waitUntil(5000);

	}

}