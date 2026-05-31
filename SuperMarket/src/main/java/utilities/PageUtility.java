package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectDropdownByIndex(WebElement element, int index) {

		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(visibleText);
	}

	public void rightClickAction(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().build().perform();

	}

	public void dragAndDropAction(WebDriver driver, WebElement drag, WebElement drop) {
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
	}

	public void javaScriptExecutor(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

	}

	public void radioButton(WebElement element) {
		element.click();
	}

	public void checkBox(WebElement element) {
		element.click();
	}
}
