package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import base.Base;
import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersTest extends Base {

	@Test(description = "create new user")
	public void verifyNewUserCreation() throws IOException {

		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSubmitButton();

		HomePage home = new HomePage(driver);
		home.clickOnMoreinfo();

		FakerUtility faker = new FakerUtility(); // create object for FakerUtility class , used fakerclass instead of
													// excel utility
		String newUserNameValue = faker.createRandomFullName();
		String newpasswordValue = faker.createRandomPassword();

		AdminUsersPage adminUser = new AdminUsersPage(driver);

		adminUser.clickOnNewUser();
		adminUser.enterUserNameInUserField(newUserNameValue);
		adminUser.enternewPasswordOnPasswordField(newpasswordValue);
		adminUser.SelectUserType();
		adminUser.clickOnSaveButton();
		boolean isAdminUserTextDisplayed = adminUser.adminTextDisplayed();
		Assert.assertTrue(isAdminUserTextDisplayed, Constants.adminUserText);
		
	}	
		@Test(description = "Search user")
public void  verifySearchUsers() throws IOException {
	String userNameValue1 = ExcelUtility.readStringData(0, 0, "LoginPage");
	String passwordValue1= ExcelUtility.readStringData(0, 1, "LoginPage");
	LoginPage loginPage1 = new LoginPage(driver);
	loginPage1.enterUserNameInUserField(userNameValue1);
	loginPage1.enterPasswordOnPasswordField(passwordValue1);
	loginPage1.clickSubmitButton();

	HomePage home1 = new HomePage(driver);
	home1.clickOnMoreinfo();

	AdminUsersPage adminUser1 = new AdminUsersPage(driver);
		adminUser1.clickOnSearchButton();
		// String searchUserNameValue = ExcelUtility.readStringData(0, 0,
		// "SearchNames");

		adminUser1.enterUserNameToSearch();
		adminUser1.selectSearchUserType();
		adminUser1.clickOnSearchButton1();
		boolean isAdminUserTextDisplayed = adminUser1.adminTextDisplayed();
		Assert.assertTrue(isAdminUserTextDisplayed, Constants.searchMessage);
		
		
}
@Test(description = "reset user")
public void verifyreset() throws IOException {
	String userNameValue1 = ExcelUtility.readStringData(0, 0, "LoginPage");
	String passwordValue1= ExcelUtility.readStringData(0, 1, "LoginPage");
	LoginPage loginPage1 = new LoginPage(driver);
	loginPage1.enterUserNameInUserField(userNameValue1);
	loginPage1.enterPasswordOnPasswordField(passwordValue1);
	loginPage1.clickSubmitButton();

	HomePage home1 = new HomePage(driver);
	home1.clickOnMoreinfo();
	AdminUsersPage adminUser2 = new AdminUsersPage(driver);
	
		adminUser2.reset();
		boolean isAdminUserTextDisplayed = adminUser2.adminTextDisplayed();
		Assert.assertTrue(isAdminUserTextDisplayed, Constants.resetMessage);
}

	}

