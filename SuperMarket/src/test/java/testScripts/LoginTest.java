package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import base.Base;
import pages.LoginPage;

public class LoginTest extends Base{

	@Test(priority =1, description="verify user login with valid credential")
	public void verifyUserLoginWithValidCredentials() throws IOException {
		
		
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver) ;
			loginPage.enterUserNameInUserField(userNameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickSubmitButton();
			boolean isDashboarddisplayed = loginPage.dashboardDisplay();  // AssertTrue 
			Assert.assertTrue(isDashboarddisplayed, "User was unable to login with valid credential");
			
	}
	@Test(priority=2, description="verify user login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInValidPassowrd() throws IOException {
		
		String userNameValue = ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver) ;
			loginPage.enterUserNameInUserField(userNameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickSubmitButton();
			String actual = loginPage.textDisplayed();
			String expected = "7rmart supermarket";
			Assert.assertEquals(actual, expected,"User was able to login with invalid password");
		
		
	}
	@Test(priority=3, description="verify user login with invalid username and valid password")
	public void verifyUserLoginWithInValidUsernameAndValidPassowrd() throws IOException
	{
		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver) ;
			loginPage.enterUserNameInUserField(userNameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickSubmitButton();
			String actual = loginPage.signTextDisplayed();
			String expected = "Sign in to start your session";
			Assert.assertEquals(actual, expected,"User Was Able to login with invalid Username");
			
	}
	
	@Test(priority=4, description="verify user login with invalid username and invalid password")
	public void verifyUserLoginWithInValidUsernameAndInValidPassowrd() throws IOException
	{
	
		String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(3, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver) ;
			loginPage.enterUserNameInUserField(userNameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickSubmitButton();
			String actual = loginPage.signInRememberText();
			String expected = "Remember Me";
			Assert.assertEquals(actual, expected,"User Was Able to login with invalid Username and password");
	}

}
