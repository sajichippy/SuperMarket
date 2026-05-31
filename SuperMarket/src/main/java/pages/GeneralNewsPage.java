package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;

public class GeneralNewsPage {
	public WebDriver driver;

	public GeneralNewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//a[@ href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement generaNewsMoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement generalNewsNewUser;
	@FindBy(id = "news")
	WebElement enterTheNews;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	WebElement MartHeading;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement serachButton;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement searchMessage;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonsearch;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//td[text()='please enter your news']")
	WebElement messg;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement manageNewsTitle;

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
	}

	public void clickOnGeneralNewsMoreInfo() {
		generaNewsMoreInfo.click();
	}

	public void clickOnNewUsers() {
		generalNewsNewUser.click();
	}

	public void enterNewsInformation() {
		enterTheNews.sendKeys(Constants.newNews);
	}

	public void clickOnSaveButton() {
		submitButton.click();
	}

	public void clickOnMartHeading() {
		MartHeading.click();
	}

	public void clickOnSearchButton() {
		serachButton.click();
	}

	public void enterOnSearchBar() {
		searchMessage.sendKeys("please enter your news");
	}

	public void clickOnNextSearchButton() {
		searchButtonsearch.click();
	}

	public void clickOnResetButton() {
		resetButton.click();
	}

	public boolean isAlertMessageDisplayed() {
		return alertMessage.isDisplayed();
	}

	public boolean isMessgDisplayed() {
		return messg.isDisplayed();
	}

	public String isTitleDisplayed() {
		return manageNewsTitle.getText();
	}
}