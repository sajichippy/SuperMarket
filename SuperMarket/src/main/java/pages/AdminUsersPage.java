package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newUser;
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

	public void enterUserNameInUserField(String userNameValue) {
		userName.sendKeys(userNameValue);
	}

	public void enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
	}

	public void clickSubmitButton() {
		submit.click();
	}

	public void clickOnNewUser() {
		newUser.click();
	}

	public void enterNewUserNameInUserField(String newUserNameValue) {
		newUserName.sendKeys(newUserNameValue);
	}

	public void enternewPasswordOnPasswordField(String newpasswordValue) {
		password.sendKeys(newpasswordValue);
	}

	public void SelectUserType() {
		Select userTypeValue = new Select(userType);
		userTypeValue.selectByIndex(2);
		userType.click();

	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clickOnSearchButton() {
		search.click();
	}

	public void enterUserNameToSearch() {
		searchUserName.sendKeys("admin");
	}

	public void selectSearchUserType() {
		Select userTypeValue = new Select(searchUserType);
		userTypeValue.selectByIndex(2);
	}

	public void clickOnSearchButton1() {

		searchButton.click();

	}

	public void reset() {
		reset.click();
	}

	public boolean adminTextDisplayed() {

		return adminUserText.isDisplayed();
	}
}
