package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import base.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends Base {

	@Test(description = "verify user logout after successful login ")
	public void verifyUserLogoutAfterLogin() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSubmitButton();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminButton();
		homePage.clickOnLogout();
		String actual = loginPage.textDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.logoutAfterLogin);

	}
}
