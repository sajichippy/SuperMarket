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
	HomePage home;
	AdminUsersPage adminUser;

	@Test(description = "create new user")
	public void verifyNewUserCreation() throws IOException {

		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home = loginPage.clickSubmitButton();

		// HomePage home = new HomePage(driver);
		adminUser = home.clickOnMoreinfo();

		FakerUtility faker = new FakerUtility(); // create object for FakerUtility class , used fakerclass instead of
													// excel utility
		String newUserNameValue = faker.createRandomFullName();
		String newpasswordValue = faker.createRandomPassword();

		// AdminUsersPage adminUser = new AdminUsersPage(driver);

		adminUser.clickOnNewUser().enterNewUserNameInUserField(newUserNameValue).enternewPasswordOnPasswordField(newpasswordValue).SelectUserType().clickOnSaveButton();
		boolean isAdminUserTextDisplayed = adminUser.adminTextDisplayed();
		Assert.assertTrue(isAdminUserTextDisplayed, Constants.adminUserText);

	}

	@Test(description = "Search user")
	public void verifySearchUsers() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home = loginPage.clickSubmitButton();

		// HomePage home = new HomePage(driver);
		adminUser = home.clickOnMoreinfo();

		// AdminUsersPage adminUser = new AdminUsersPage(driver);
		adminUser.clickOnSearchButton();
		// String searchUserNameValue = ExcelUtility.readStringData(0, 0,
		// "SearchNames");

		adminUser.enterUserNameToSearch();
		adminUser.selectSearchUserType();
		adminUser.clickOnSearchButton();
		boolean isAdminUserTextDisplayed = adminUser.adminTextDisplayed();
		Assert.assertTrue(isAdminUserTextDisplayed, Constants.searchMessage);

	}

	@Test(description = "reset user")
	public void verifyreset() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home = loginPage.clickSubmitButton();

		// HomePage home = new HomePage(driver);
		adminUser = home.clickOnMoreinfo();
		// AdminUsersPage adminUser = new AdminUsersPage(driver);

		adminUser.reset();
		boolean isAdminUserTextDisplayed = adminUser.adminTextDisplayed();
		Assert.assertTrue(isAdminUserTextDisplayed, Constants.resetMessage);
	}

}
