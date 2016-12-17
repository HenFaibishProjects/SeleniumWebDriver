package Gustavo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homepage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	private String url = "http://www.photo-workshops.co.il/";
	
	private String user = "admin";
	private String password = "pass";

	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.gecko.driver", "D:/DOK/Selenium/drivers/Chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get(url);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
		actions = new Actions(driver);

		 
	}

	@Test
	public void testCreateLead() throws InterruptedException   {
		 

		
		 driver.findElement(By.xpath("id('center')/x:div[1]/x:ul/x:li[6]/x:a/x:img")).click();
			
												
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("contact[name]")));
		String t1 = "someone" + System.currentTimeMillis();
		name.sendKeys(t1);
		
		
		WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("contact[email]")));
		String t2 = "mail" + System.currentTimeMillis() + "@mail.com";
		mail.sendKeys(t2);
		
		WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("contact[phone]")));
		String t3 = "3" + System.currentTimeMillis();
		lastname.sendKeys(t3);
		
		
		WebElement note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("contact[note]")));
		String t4 = "note" + System.currentTimeMillis();
		note.sendKeys(t4);
		
		
		String trng = note.getText();
		Thread.sleep(5000);										
		System.out.println(trng);										
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
