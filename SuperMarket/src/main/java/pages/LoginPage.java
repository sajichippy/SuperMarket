package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and @class='small-box-footer']")
	WebElement dashBoard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginText;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement signInText;
	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberText;

	public void enterUserNameInUserField(String userNameValue) {
		userName.sendKeys(userNameValue);
	}

	public void enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
	}

	public void clickSubmitButton() {
		submit.click();
	}

	public boolean dashboardDisplay() {

		return dashBoard.isDisplayed();

	}

	public String textDisplayed() {
		return loginText.getText();
	}

	public String signTextDisplayed() {
		return signInText.getText();
	}

	public String signInRememberText() {
		return rememberText.getText();
	}
}
