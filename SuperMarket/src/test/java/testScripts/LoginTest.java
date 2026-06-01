package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import base.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends Base {
	
	HomePage home;

	@Test(priority = 1, description = "verify user login with valid credential", groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {

		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home= loginPage.clickSubmitButton();
		boolean isDashboarddisplayed = loginPage.dashboardDisplay(); // AssertTrue
		Assert.assertTrue(isDashboarddisplayed, Constants.validCredentialError);

	}

	@Test(priority = 2, description = "verify user login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInValidPassowrd() throws IOException {

		String userNameValue = ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickSubmitButton();
		String actual = loginPage.textDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected , Constants.invalidpasswordError);

	}

	@Test(priority = 3, description = "verify user login with invalid username and valid password")
	public void verifyUserLoginWithInValidUsernameAndValidPassowrd() throws IOException {
		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickSubmitButton();
		String actual = loginPage.signTextDisplayed();
		String expected = "Sign in to start your session";
		Assert.assertEquals(actual, expected, Constants.invalidUserNameError);

	}

	@Test(priority = 4, description = "verify user login with invalid username and invalid password", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyUserLoginWithInValidUsernameAndInValidPassowrd(String userNameValue, String passwordValue) throws IOException {

		//String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
	//	String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickSubmitButton();
		String actual = loginPage.signInRememberText();
		String expected = "Remember Me";
		Assert.assertEquals(actual, expected, Constants.inValidCredentialError);
	}
	@DataProvider(name = "loginProvider") 
 	public Object[][] getDataFromDataProvider() throws IOException { 
  
 		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }, 
 				// new Object[] {ExcelUtility.getStringData(3, 
 				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")} 
 		};
}}
