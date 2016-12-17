package logindemo;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	
	protected final WebDriver driver;
	
	protected ActionBot bot;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
		bot = new ActionBot(driver);
		assertInPage();
	}
	
	protected abstract void assertInPage();
	
	
}
