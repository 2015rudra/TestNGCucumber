package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestUtil.TestBase;
import TestUtil.Util;




public class LoginPage extends TestBase
{
	WebDriverWait wait;
	Util util;
	
	@FindBy(name="email")
	WebElement uname;

	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	private By loginPanel = By.xpath("//div[@class='ui stacked segment']");
	
	public LoginPage() throws IOException 
	{
		super();
		PageFactory.initElements(driver, this);
		util = new Util();
		wait = new WebDriverWait(driver, 30);
	}
	
	
	public String getPageTitle() 
	{
		return driver.getTitle();
	}
	
	public HomePage login(String username, String Password) throws IOException 
	{

		wait.until(ExpectedConditions.visibilityOfElementLocated (loginPanel));
		uname.clear();
		uname.sendKeys(username);
		pwd.clear();
		pwd.sendKeys(Password);
		loginButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loginPanel));
		
		return new HomePage();
	}
	
	public void tearDown() 
	{
		driver.quit();
	}

}
