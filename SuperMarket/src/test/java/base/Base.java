package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver; 
	
	@BeforeMethod
	public void browserLaunch(){
		
		driver = new ChromeDriver();  
		                                    
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void browserCloseAndQuit() {

	  driver.quit();
	}

}
