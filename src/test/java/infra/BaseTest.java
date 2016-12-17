package infra;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest   {


	/******************************* MEMBERS **********************************************/
	protected static final Logger LOGGER = Logger.getLogger(BaseTest.class.getName());
	//protected static String webServerURL;
	protected static WebDriver driver ;



	public static void startthesettings(String browserName,String URL) {



		switch (browserName) {
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "E:/ffselenium/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(URL);
			LOGGER.config("Firefox Browser Chosen");
			break;
		case "IE":
			System.setProperty("webdriver.gecko.driver", "E:/ffselenium/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(URL);
			LOGGER.config("Int Browser Chosen");
			break;
		case "Chrome":
			System.setProperty("webdriver.gecko.driver", "E:/ffselenium/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(URL);
			LOGGER.config("Chrome Browser Chosen");
			break;
		}


	}

	public static void deleteAllCookiesInTheBrowser() {
		driver.manage().deleteAllCookies();
	}
	
	public static void waitUntil(int timeOnSeconds) {
		try {
			Thread.sleep(timeOnSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
