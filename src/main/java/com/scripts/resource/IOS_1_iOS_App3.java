package com.scripts.resource;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class IOS_1_iOS_App3 {
	IOSDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void run() throws MalformedURLException, InterruptedException {
		String seleniumHubUrl = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=547c9fa1-4e4f-4028-b04e-41678085470a&licenseId=LIC4639&projectName=webAndMobile/";
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appium:deviceName", "iPhone 11");
		caps.setCapability("appium:platformName", "iOS");
		caps.setCapability("appium:platformVersion", "15.5");
		caps.setCapability("appium:app", "Myntra 4.2411.20.ipa");
		caps.setCapability("appium:bundleId", "com.myntra.Myntra");// Pls change the bundleId value to proper value.
		caps.setCapability("appium:automationName", "XCUITest");
		caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
		caps.setCapability("appium:fullReset", true);
		driver = new IOSDriver(new URL(seleniumHubUrl), caps);

	}

	@Test
	public void steps() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		// Step 1: Wait for app to load
		Thread.sleep(6000);

		// Step 2: Handle “Select Your Store” popup (choose any store)
		try {
			WebElement selectStore = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//XCUIElementTypeStaticText[contains(@name,'Select your store')]")));
			if (selectStore.isDisplayed()) {
				List<WebElement> stores = driver.findElements(By.xpath("//XCUIElementTypeButton"));
				if (!stores.isEmpty()) {
					stores.get(0).click(); // select the first store
					System.out.println("Store selected successfully.");
				}
			}
		} catch (Exception e) {
			System.out.println("Store selection popup not displayed.");
		}

		// Step 3: Wait for Home Page to load
		Thread.sleep(4000);

		// Step 4: Click on the Search bar
		WebElement searchBar = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//XCUIElementTypeOther[contains(@name,'Search')])[1]")));
		searchBar.click();

		// Step 5: Enter search term
		WebElement searchInput = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeTextField")));
		searchInput.sendKeys("T-shirt");

		// Step 6: Select the first suggestion
		Thread.sleep(2000);
		List<WebElement> suggestions = driver
				.findElements(By.xpath("//XCUIElementTypeOther[contains(@name,'tshirt')]"));
		if (!suggestions.isEmpty()) {
			suggestions.get(0).click();
		}

		// Step 7: Wait for product listing to appear
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeOther[contains(@name,'ProductItem')])[1]")));

		// Step 8: Click on first product
		driver.findElement(By.xpath("(//XCUIElementTypeOther[contains(@name,'ProductItem')])[1]")).click();

		// Step 9: Wait for product details page
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Add to Bag')]")));

		// Step 10: Click on Add to Bag
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Add to Bag')]")).click();

		// Step 11: Wait for size options and select one
		List<WebElement> sizes = driver.findElements(By.xpath("//XCUIElementTypeOther[contains(@name,'Size')]"));
		if (!sizes.isEmpty()) {
			sizes.get(0).click(); // select first available size
		}

		// Step 12: Confirm Add to Bag
		WebElement addButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[contains(@name,'DONE')]")));
		addButton.click();

		// Step 13: Go to Bag icon
		Thread.sleep(3000);
		WebElement bagIcon = driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,'Bag')]"));
		bagIcon.click();

		// Step 14: Verify product is added to Bag
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name,'T-shirt')]")));
		System.out.println("Product successfully added to bag.");

		// Step 15: Remove product from Bag (cleanup)
		List<WebElement> removeBtns = driver
				.findElements(By.xpath("//XCUIElementTypeStaticText[contains(@name,'REMOVE')]"));
		if (!removeBtns.isEmpty()) {
			removeBtns.get(0).click();
			System.out.println("Product removed successfully.");
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	// Wait to see the app open

}
