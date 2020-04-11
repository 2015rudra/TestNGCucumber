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



public class HomePage extends TestBase
{
	
	WebDriverWait wait;
	Util util;
	
	
	  @FindBy(xpath="//span[@class='user-display']") WebElement loggedUsername;
	 
	
//	By loggedUsername = By.xpath("//span[@class='user-display']");
	
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		
			PageFactory.initElements(driver, this);
			util = new Util();
			wait = new WebDriverWait(driver, 30);
		
	}

	
	
	
	
	public String getLoggedInUserName() 
	{
		util.waitForAnObject(driver, loggedUsername, util.minWait);
//		wait.until(ExpectedConditions.visibilityOfElementLocated (loggedUsername));
//		System.out.println(loggedUsername.getText());
		return loggedUsername.getText();
	}

}
