package com.scripts.basefolder;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.report.listener.ExtentReportManager;

import lombok.Data;

@Data
public class BaseMethodsCloud {
	WebDriver driver;
	Actions act;
	BaseObjectsCloud baseObjects;
	ExtentReportManager report;

	// Constructor
	public BaseMethodsCloud(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		baseObjects = new BaseObjectsCloud(driver);
		report = new ExtentReportManager();

	}

	public void TypeText(WebElement expectedElement, String data) {
		
		baseObjects.getwaitUntilVisibilityOfElement(expectedElement).sendKeys(data);
	}

	public void presskeys(WebElement expectedElement, Keys key , String message) {
		baseObjects.getwaitUntilVisibilityOfElement(expectedElement).sendKeys(key);
	}

	public void MouseHoverOnElementAndClick(WebElement expectedElement,String message) {
		baseObjects.getwaitUntilVisibilityOfElement(expectedElement);
		act.moveToElement(expectedElement).click().perform();
		
	}

	public void MouseHoverOnElement(WebElement expectedElement, String message) {

		baseObjects.getwaitUntilVisibilityOfElement(expectedElement);
		act.moveToElement(expectedElement).build().perform();

	}

	public void WaitUntilVisibilityOfElement(WebElement expectedElement,String message) {
		baseObjects.getwaitUntilVisibilityOfElement(expectedElement);
	}

	public void PrintValue(String Value) {
		System.out.println(Value);
	}

	public String GetText(WebElement expectedElement,String message) {
		return baseObjects.getwaitUntilVisibilityOfElement(expectedElement).getText();

	}

	public void assertVerifyByActualAndExpectedValue(String value1, String value2,String message) {
		Assert.assertEquals(value1, value2);

	}

	public void getString(String URL, String message) {
		driver.get(URL);
	}

	public void Navigateinto(String pageURL,String message) {
		driver.navigate().to(pageURL);
	}

	public void MaximizeBrowser(WebDriver driver, String message) {
		driver.manage().window().maximize();
	}

	public void ImplicitWait(WebDriver driver, int time, String message) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public String FetchBrowserTitle(String message) {
		return driver.getTitle();
	}

	public void HardWait(int time,String message) throws InterruptedException {
		Thread.sleep(time);
	}

	public void waitForPageLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public Boolean ElementIsDisplay(WebElement expectedElement) {
		return baseObjects.getwaitUntilVisibilityOfElement(expectedElement).isDisplayed();
	}

	public void Click(WebElement expectedElement) {
		baseObjects.getwaitUntilVisibilityOfElement(expectedElement).click();
	}

	public void ClickByPresenceString(String expectedElement) {
		baseObjects.getwaitUntilPresenceOfElement(expectedElement).click();
	}

	public Boolean RadioButtonIsSeleted(WebElement expectedElement) {
		return baseObjects.getwaitUntilVisibilityOfElement(expectedElement).isSelected();
	}

	public String generateAStringOfSize(int size) {
		String s = "";
		while (s.length() < size) {
			s += UUID.randomUUID().toString();
		}

		return s.substring(0, size);
	}

}
