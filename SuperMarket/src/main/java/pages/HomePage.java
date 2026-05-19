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
	
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement AdminButton;
	@FindBy(linkText="Logout")WebElement clickLogout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")
	WebElement adminMoreInfo;
	
	 
   public void clickOnAdminButton() {
	   AdminButton.click();
   }
   public void clickOnLogout() {
	   
	   clickLogout.click();
	 
	   
   }
   public void clickOnMoreinfo() {
		adminMoreInfo.click();
	}

   
   }
