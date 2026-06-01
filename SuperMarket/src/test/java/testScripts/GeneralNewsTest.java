package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import constants.Constants;
import pages.GeneralNewsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class GeneralNewsTest extends Base {

	@Test(description = "create new user")
	public void verifyNewUserCreation() throws IOException {

		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSubmitButton();

		GeneralNewsPage generalNews = new GeneralNewsPage(driver);
		generalNews.scrollDown();

		HomePage home = new HomePage(driver);
		home.clickOnGeneralNewsMoreInfo();

		generalNews.clickOnNewUsers();
		generalNews.enterNewsInformation();
		generalNews.clickOnSaveButton();
		boolean isAlerDisplayed = generalNews.isAlertMessageDisplayed();
		Assert.assertTrue(isAlerDisplayed, Constants.newUserCreation);

	}

	@Test(description = "search user")
	public void verifySearchExistingUser() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSubmitButton();

		GeneralNewsPage generalNews1 = new GeneralNewsPage(driver);
		generalNews1.scrollDown();

		HomePage home = new HomePage(driver);
		home.clickOnGeneralNewsMoreInfo();
		// generalNews.clickOnMartHeading();
		generalNews1.clickOnSearchButton();
		generalNews1.enterOnSearchBar();
		generalNews1.clickOnNextSearchButton();
		boolean ismessgDisplayed = generalNews1.isMessgDisplayed();
		Assert.assertTrue(ismessgDisplayed, Constants.searchExixtingUser);
	}

	@Test(description = "reset user")
	public void verifyUserReset() throws IOException {
	
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickSubmitButton();

		GeneralNewsPage generalNews2 = new GeneralNewsPage(driver);
		generalNews2.scrollDown();

		HomePage home = new HomePage(driver);
		home.clickOnGeneralNewsMoreInfo();
		generalNews2.clickOnResetButton();
		String actual = generalNews2.isTitleDisplayed();
		String expected = "Manage News";
		Assert.assertEquals(actual, expected);
	}
}
