package logindemo;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionBot {
	
	private final WebDriver driver;
	
	public ActionBot(WebDriver driver){
		this.driver = driver;
	}
	
	public void sendKeysToElementBy(By elementBy,String text){
		WebElement element = driver.findElement(elementBy);
		element.clear();
		element.sendKeys(text);
	}
	
}
