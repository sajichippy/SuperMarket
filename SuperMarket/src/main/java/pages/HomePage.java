package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement AdminButton;
	@FindBy(linkText = "Logout")
	WebElement clickLogout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")
	WebElement adminMoreInfo;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginText;
	@FindBy(xpath = "//a[@ href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement generalNewsMoreInfo;

	public HomePage clickOnAdminButton() {
		AdminButton.click();
		return this;
	}

	public LoginPage clickOnLogout() {

		clickLogout.click();
		return new LoginPage(driver);

	}

	public AdminUsersPage clickOnMoreinfo() {
		adminMoreInfo.click();
		return new AdminUsersPage(driver);
	}

	public String textDisplayed() {
		return loginText.getText();
	}

	public void clickOnGeneralNewsMoreInfo() {
		generalNewsMoreInfo.click();
	}
}
