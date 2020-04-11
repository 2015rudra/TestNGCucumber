package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import Pages.HomePage;
import Pages.LoginPage;
import TestUtil.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginStepDefinition extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginStepDefinition() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("^user launch browser$")
	public void user_launch_browser()  
	{
		TestBase.initilization();
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() throws IOException 
	{
		loginPage = new LoginPage();
		String title = loginPage.getPageTitle();
		Assert.assertEquals("Cogmento CRM", title);

	}

	@Then("^user logs into application$")
	public void user_logs_into_application() throws IOException 
	{
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}


	@Then("^validate logged in username is displayed$")
	public void validate_logged_in_username_is_displayed() 
	{

		String username = homePage.getLoggedInUserName();
		Assert.assertEquals("Rupesh Kadam", username);
	}
	
	@Then("^user closes browser$")
	public void close_the_browser() 
	{

		loginPage.tearDown();
		
	}

}
