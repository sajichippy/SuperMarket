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
	GeneralNewsPage generalNews ;
	HomePage home ;
	

	@Test(description = "create new user")
	public void verifyNewUserCreation() throws IOException {

		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickSubmitButton();

		//GeneralNewsPage generalNews = new GeneralNewsPage(driver);
		generalNews.scrollDown();

	//	HomePage home = new HomePage(driver);
		generalNews= home.clickOnGeneralNewsMoreInfo();

		generalNews.clickOnNewUsers().enterNewsInformation().clickOnSaveButton();
		boolean isAlerDisplayed = generalNews.isAlertMessageDisplayed();
		Assert.assertTrue(isAlerDisplayed, Constants.newUserCreation);

	}

	@Test(description = "search user")
	public void verifySearchExistingUser() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickSubmitButton();

		//GeneralNewsPage generalNews = new GeneralNewsPage(driver);
		generalNews.scrollDown();

		//HomePage home = new HomePage(driver);
		generalNews=	home.clickOnGeneralNewsMoreInfo();
		// generalNews.clickOnMartHeading();
		generalNews.clickOnSearchButton().enterOnSearchBar().clickOnNextSearchButton();
		boolean ismessgDisplayed = generalNews.isMessgDisplayed();
		Assert.assertTrue(ismessgDisplayed, Constants.searchExixtingUser);
	}

	@Test(description = "reset user")
	public void verifyUserReset() throws IOException {
	
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameInUserField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickSubmitButton();

		//GeneralNewsPage generalNews = new GeneralNewsPage(driver);
		generalNews.scrollDown();

		//HomePage home = new HomePage(driver);
		generalNews=home.clickOnGeneralNewsMoreInfo();
		generalNews.clickOnResetButton();
		String actual = generalNews.isTitleDisplayed();
		String expected = "Manage News";
		Assert.assertEquals(actual, expected);
	}
}
