package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class Base {

	public WebDriver driver;
	@Parameters("browsers")
	@BeforeMethod
	
	public void browserLaunch(String browsers) throws Exception {
if(browsers.equalsIgnoreCase("Chrome")) {
	driver = new ChromeDriver();
}
else if(browsers.equalsIgnoreCase("firefox"))
{
	driver = new FirefoxDriver();
}
else if(browsers.equalsIgnoreCase("Edge")) {
	driver = new EdgeDriver();
	
}
else {
	throw new Exception("Invalid Browser");
}
	
        driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait and duration is pre-defiened class that why we need select whatever method we need
	
	}

	@AfterMethod
	public void driverCloseAndQuit(ITestResult iTestResult) throws IOException { // ITest pre define interface

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

	}

}
