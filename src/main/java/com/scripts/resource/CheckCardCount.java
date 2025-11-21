package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckCardCount 
{
	WebDriver driver;
	@BeforeClass
	public void initialize() throws MalformedURLException
	{
		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=5349b454-3aa5-4d96-ac8b-629e448e2c8b&licenseId=LIC3931&projectName=Automation+testing/";
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("131");
		driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
		driver.manage().window().setSize(new Dimension(1024, 768));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com");
	}
	
	@Test(invocationCount = 2)
	public void test1() throws InterruptedException
	{
		driver.navigate().to("https://www.pantaloons.com");
		Thread.sleep(2000);
	}
	
	@Test(invocationCount = 2)
	public void test2()throws InterruptedException
	{
		driver.navigate().to("https://www.jiomart.com");
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}

