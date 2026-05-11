package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.ExcelUtility;
import base.Base;

public class LoginTest extends Base{

	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException {
		
		
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver) ;
			loginPage.enterUserNameInUserField(userNameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickSubmitButton();
		
	}
	@Test
	public void verifyUserLoginWithValidUsernameAndInValidPassowrd() throws IOException {
		
		String userNameValue = ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver) ;
			loginPage.enterUserNameInUserField(userNameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickSubmitButton();
		
		
	}
	@Test
	public void verifyUserLoginWithInValidUsernameAndValidPassowrd() throws IOException
	{
		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver) ;
			loginPage.enterUserNameInUserField(userNameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickSubmitButton();
	}
	
	@Test
	public void verifyUserLoginWithInValidUsernameAndInValidPassowrd() throws IOException
	{
	
		String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(3, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver) ;
			loginPage.enterUserNameInUserField(userNameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickSubmitButton();
	}

}
