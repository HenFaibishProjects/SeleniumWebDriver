package tevaCastel;

import java.net.UnknownHostException;
import java.util.Calendar;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameters;

import infra.BaseTest;



public class TevaCastelBaseTest extends BaseTest  {

	/******************************* MEMBERS **********************************************/

	protected String preferendWebBrowser = "Firefox";
	protected String webServerURL = "http://lp.infopage.mobi/index.php?page=landing&id=29871&token=cd6274314204f0b7342f35ae9dfa0165";
    protected String fullNameF= "field[927607]";   
    protected String telephoneId = "field[927609]";
    protected String numberCstelId = "field[927611]";
    protected String chargeAmountid  = "field[927613]";
    protected String hourId = "field[927615]";
    
    

}


