package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newUserButton;
	@FindBy(id = "username")
	WebElement newUserName;
	@FindBy(id = "password")
	WebElement newPassword;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement userType;
	@FindBy(id = "user_type")
	WebElement partner;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(id = "un")
	WebElement searchUserName;
	@FindBy(id = "ut")
	WebElement searchUserType;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement reset;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	WebElement activeMessage;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement adminUserText;

	
	public AdminUsersPage clickOnNewUser() {
		newUserButton.click();
		return this;
	}

	public AdminUsersPage enterNewUserNameInUserField(String newUserNameValue) {
		newUserName.sendKeys(newUserNameValue);
		return this;
	}

	public AdminUsersPage enternewPasswordOnPasswordField(String newpasswordValue) {
		newPassword.sendKeys(newpasswordValue);
		return this;
	}

	public AdminUsersPage SelectUserType() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownByIndex(userType, 2);
		return this;
		
	/*	Select userTypeValue = new Select(userType);
		userTypeValue.selectByIndex(2);
		userType.click();*/

	}

	public AdminUsersPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public AdminUsersPage clickOnSearchButton() {
		search.click();
		return this;
	}

	public AdminUsersPage enterUserNameToSearch() {
		searchUserName.sendKeys(Constants.searchUser);
		return this;
	}

	public AdminUsersPage selectSearchUserType() {
		PageUtility page = new PageUtility();
		page.selectDropdownByIndex(searchUserType, 2);
		return this;
	//	Select userTypeValue = new Select(searchUserType);
	//	userTypeValue.selectByIndex(2);
	}

	public AdminUsersPage clickOnSearchButton1() {

		searchButton.click();
		return this;

	}

	public AdminUsersPage reset() {
		reset.click();
		return this;
	}

	public boolean adminTextDisplayed() {

		return adminUserText.isDisplayed();
	}
}
