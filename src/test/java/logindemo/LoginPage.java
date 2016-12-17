package logindemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends LoginApplicationAbstractPage {

	private By alertMessageBy = By.className("alert-danger");
	private By loginBtnBy = By.className("btn-primary");
	private By pageTitleBy = By.xpath("//h2[text()='Login']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage doLogin(String userName, String password) {
		typeToUserNameTb(userName);
		typeToPasswordTb(password);
		return clickOnLoginBtnAndGoToHomePage();
	}


	public LoginPage typeToUserNameTb(String userName) {
		bot.sendKeysToElementBy(By.id("username"), userName);
		return this;
	}

	public LoginPage typeToPasswordTb(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}

	public HomePage clickOnLoginBtnAndGoToHomePage() {
		driver.findElement(loginBtnBy).click();
		return new HomePage(driver);
	}

	public LoginPage clickOnLoginBtnAndStayInLoginPage() {
		driver.findElement(loginBtnBy).click();
		return this;
	}

	public String getErrorMessageText() {
		return driver.findElement(alertMessageBy).getText();
	}

	@Override
	protected void assertInPage() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleBy ));
	}

}
