package com.scripts.resource;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

public class RoughScript 
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	WebDriverWait wait ;
	String products;

	@BeforeClass
	public void driverinitiation() throws InterruptedException, MalformedURLException
	{
		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=9adfe132-9652-4329-a206-4c8ee67e0281&licenseId=LIC3943&projectName=project+5/";
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("136");
		driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
		driver.manage().window().setSize(new Dimension(1024, 768));

		
		//this.driver = new ChromeDriver();


		// Fetch system info
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getBrowserVersion();
		String platform = caps.getPlatformName().toString();

		System.out.println("Browser: " + browserName);
		System.out.println("Version: " + browserVersion);
		System.out.println("Platform: " + platform);

		this.baseMethod = new BaseMethodsCloud(driver);
		this.baseObject = new BaseObjectsCloud(driver);
		this.baseData = new BaseDataCloud();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.products = "Shirts";

		pantaloonsLandingPage = new PantaloonsLandingPage(driver);
		baseMethod.ImplicitWait(driver, 30,"Implicit wait is applied");
		baseMethod.HardWait(2000,"Hard wait applied");
	}

	
	//-----------------Browser Related Methods----------------
		@Test(priority = 1)
		public void browserRelatedMethods()
		
		{
			
		}

	@AfterClass
	public void QuitBrowser()
	{
		driver.quit();
	}
}
