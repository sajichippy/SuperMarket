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
		

		adminUser.clickOnSearchButton();
		// String searchUserNameValue = ExcelUtility.readStringData(0, 0,
		// "SearchNames");

		adminUser.enterUserNameToSearch();
		adminUser.selectSearchUserType();
		adminUser.clickOnSearchButton1();

		adminUser.reset();
		boolean isAdminUserTextDisplayed = adminUser.adminTextDisplayed();
		Assert.assertEquals(isAdminUserTextDisplayed, Constants.adminUserText);

	}
}
