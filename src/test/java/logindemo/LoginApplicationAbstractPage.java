package logindemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class LoginApplicationAbstractPage extends AbstractPage {
	
	private By jasonWatmoreBy = By.linkText("JasonWatmore.com");
	
	public LoginApplicationAbstractPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnJasonLnk(){
		driver.findElement(jasonWatmoreBy).click();
	}

	
}
